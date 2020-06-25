package redhot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import redhot.bean.BookBean;
import redhot.bean.BorrowBean;
import redhot.bean.StockBean;

public class BookManageDAO extends MainDAO {

	public BookManageDAO() throws DAOException {
		getConnection();
	}

	//	public List searchBook(int isbn, String name , int classId, String author,
	//			String publisher, java.sql.Date releaseDate) throws DAOException {
	public List<StockBean> searchBook(String isbn, String name, String classId,
			String author, String publisher,
			String releaseDate) throws DAOException {

		// Bookテーブルに実行するSQL文
		String sqlSelectFromBook = "select * from book";
		ArrayList<String> whereList = new ArrayList<String>();
		ArrayList<String> valueList = new ArrayList<String>();
		ArrayList<Integer> valueIntList = new ArrayList<Integer>();

		if (!"".equals(isbn)) {
			whereList.add("isbn = ?");
			valueList.add(isbn);
		}
		if (!"".equals(name)) {
			whereList.add("name = ?");
			valueList.add(name);
		}
		if (!"".equals(author)) {
			whereList.add("author = ?");
			valueList.add(author);
		}
		if (!"".equals(publisher)) {
			whereList.add("publisher = ?");
			valueList.add(publisher);
		}
		if (!"".equals(releaseDate)) {
			whereList.add("releaseDate = ?");
			valueList.add(releaseDate);
		}
		if (!"".equals(classId)) {
			whereList.add("class_id = ?");
			valueIntList.add(Integer.valueOf(classId));
		}

		if (whereList.size() != 0) {
			sqlSelectFromBook += " WHERE " + String.join(" AND ", whereList);
		}

		ResultSet rsBook = null;
		List<BookBean> bookBeans = new ArrayList<BookBean>();

		String sqlSelectFromStock = "select * from stock where  book_isbn = ? ";
		ResultSet rsStock = null;
		List<StockBean> stockBeans = new ArrayList<StockBean>();

		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sqlSelectFromBook);
				PreparedStatement st2 = con.prepareStatement(sqlSelectFromStock)) {
			for (int i = 0; i < valueList.size(); i++) {
				st.setString(i + 1, valueList.get(i));
			}
			for (int i = valueList.size(); i < valueList.size() + valueIntList.size(); i++) {
				st.setInt(i + 1, valueIntList.get(i - valueList.size()));
			}
			rsBook = st.executeQuery();

			while (rsBook.next()) {
				String bookIsbn = rsBook.getString("isbn");
				String bookName = rsBook.getString("name");
				int bookClassId = rsBook.getInt("class_id");
				String bookAuthor = rsBook.getString("author");
				String bookPublisher = rsBook.getString("publisher");
				java.sql.Date bookReleaseDate = rsBook.getDate("release_date");
				BookBean bookBean = new BookBean(bookIsbn, bookName, bookClassId,
						bookAuthor, bookPublisher, bookReleaseDate);
				bookBeans.add(bookBean);
			}
			for (BookBean bean : bookBeans) {
				st2.setString(1, bean.getIsbn());
				rsStock = st2.executeQuery();
				while (rsStock.next()) {
					int stockId = rsStock.getInt("id");
					String bookIsbn = rsStock.getString("book_isbn");
					java.sql.Date inDate = rsStock.getDate("in_date");
					java.sql.Date outDate = rsStock.getDate("out_date");
					String status = rsStock.getString("status");
					StockBean sbean = new StockBean(stockId, bookIsbn, inDate,
							outDate, status, bean);
					stockBeans.add(sbean);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました", e);
		} finally {
			try {
				if (rsBook != null)
					rsBook.close();

			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("リソースの開放に失敗しました", e);
			}
		}
		return stockBeans;
	}

	//本を削除する（廃棄年月日・statusの変更）
	public String deleteBook(int id) throws DAOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //年月日にフォーマットする用
		Date today = new Date();
		String today_format = dateFormat.format(today); //yyyy-MM-ddの形にフォーマットしている
		String sql = "UPDATE stock SET out_date='" + today_format + "',status='none' WHERE id=?";
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, id);
			st.executeUpdate();
			return "本を1冊廃棄しました";
		} catch (SQLException e) {
			throw new DAOException("レコードの取得に失敗しました", e);
		}
	}

	//本を貸出する（BorrowDBの会員ID・資料ID・StockDBのstatusを変更）
	public List<BorrowBean> borrowBook(int member_id, List<String> book_id) throws DAOException {

		//今日の日付と10日後の日付取得
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //年月日にフォーマットする用

		LocalDateTime l_today = LocalDateTime.now();
		LocalDateTime l_later10_day = l_today.plusDays(10);

		Date today = Date.from(l_today.toInstant(ZoneId.systemDefault().getRules().getOffset(l_today)));
		Date later10_day = Date
				.from(l_later10_day.toInstant(ZoneId.systemDefault().getRules().getOffset(l_later10_day)));
		String later10_day_format = dateFormat.format(later10_day);
		String today_format = dateFormat.format(today); //yyyy-MM-ddの形にフォーマットしている

		List<BorrowBean> borrowBeans = new ArrayList<BorrowBean>();
		ResultSet rs = null;
		int max = 0;
		String status = null;

		for (int i = 0; i < book_id.size(); i++) {
			String sqlStockStatus = "SELECT status FROM stock WHERE id = ?";
			String sqlStockStatusUpdate = "UPDATE stock SET status='borrow' WHERE id = ?";
			String sql = "INSERT INTO borrow(stock_id,user_id,borrow_date,will_return_date) VALUES("
					+ book_id.get(i) + ",?,'"
					+ today_format + "','"
					+ later10_day_format + "')";
			String sqlMaxId = "SELECT MAX(id) as max FROM borrow";
			String sqlSelect = "SELECT * FROM borrow WHERE id = ?";
			try (Connection con = getConnection();
					PreparedStatement st = con.prepareStatement(sqlStockStatus);
					PreparedStatement st0 = con.prepareStatement(sqlStockStatusUpdate);
					PreparedStatement st1 = con.prepareStatement(sql);
					PreparedStatement st2 = con.prepareStatement(sqlMaxId);
					PreparedStatement st3 = con.prepareStatement(sqlSelect);) {

				st.setInt(1, Integer.parseInt(book_id.get(i)));
				rs = st.executeQuery();
				rs.next();
				status = rs.getString("status");
				rs.close();

				if ("exist".equals(status)) {
					st0.setInt(1, Integer.parseInt(book_id.get(i)));
					st0.executeUpdate();

					st1.setInt(1, member_id);
					st1.executeUpdate();

					rs = st2.executeQuery();
					rs.next();
					max = rs.getInt("max");
					rs.close();

					st3.setInt(1, max);
					rs = st3.executeQuery();
					rs.next();
					int id = rs.getInt("id");
					int stockid = rs.getInt("stock_id");
					int userid = rs.getInt("user_id");
					java.sql.Date borrowDate = rs.getDate("borrow_date");
					java.sql.Date willReturnDate = rs.getDate("will_return_date");
					java.sql.Date returnDate = rs.getDate("return_date");
					BorrowBean borrowBean = new BorrowBean(id, stockid, userid, borrowDate, willReturnDate, returnDate);
					borrowBeans.add(borrowBean);
				} else {
					BorrowBean borrowBean = new BorrowBean(0, Integer.parseInt(book_id.get(i)), member_id);
					borrowBeans.add(borrowBean);
				}

			} catch (SQLException e) {
				throw new DAOException("レコードの変更・レコードの取得に失敗しました", e);
			} finally {
				try {
					if (rs != null)
						rs.close();
				} catch (Exception e) {
					e.printStackTrace();
					throw new DAOException("リソースの開放に失敗しました", e);
				}
			}
		}
		return borrowBeans;
	}

	//本を返却する
	public List<BorrowBean> returnBook(int member_id, List<String> book_id) throws DAOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //年月日にフォーマットする用
		Date today = new Date();
		String today_format = dateFormat.format(today); //yyyy-MM-ddの形にフォーマットしている

		List<BorrowBean> borrowBeans = new ArrayList<BorrowBean>();
		ResultSet rs = null;
		ResultSet rs2 = null;

		String return_date = null;

		for (int i = 0; i < book_id.size(); i++) {
			String sqlBorrowCheck = "SELECT id,return_date FROM borrow WHERE user_id = ? AND stock_id=?";
			String sqlStockStatusUpdate = "UPDATE stock SET status='returned' WHERE id = ?";
			String sqlBorrowReturnDateUpdate = "UPDATE borrow SET return_date='" + today_format + "' WHERE id = ?";
			String sqlSelect = "SELECT * FROM borrow WHERE id = ?";
			try (Connection con = getConnection();
					PreparedStatement st = con.prepareStatement(sqlBorrowCheck);
					PreparedStatement st1 = con.prepareStatement(sqlStockStatusUpdate);
					PreparedStatement st2 = con.prepareStatement(sqlBorrowReturnDateUpdate);
					PreparedStatement st3 = con.prepareStatement(sqlSelect);) {
				st.setInt(1, member_id);
				st.setInt(2, Integer.parseInt(book_id.get(i)));
				rs = st.executeQuery();
				while (rs.next()) {
					return_date = rs.getString("return_date");
					if (return_date == null) {
						st1.setInt(1, Integer.parseInt(book_id.get(i)));
						st1.executeUpdate();
						st2.setInt(1, rs.getInt("id"));
						st2.executeUpdate();
						st3.setInt(1, rs.getInt("id"));
						rs2 = st3.executeQuery();
						rs2.next();
						int id = rs2.getInt("id");
						int stockid = rs2.getInt("stock_id");
						int userid = rs2.getInt("user_id");
						java.sql.Date borrowDate = rs2.getDate("borrow_date");
						java.sql.Date willReturnDate = rs2.getDate("will_return_date");
						java.sql.Date returnDate = rs2.getDate("return_date");
						BorrowBean borrowBean = new BorrowBean(id, stockid, userid, borrowDate, willReturnDate,
								returnDate);
						borrowBeans.add(borrowBean);
						rs2.close();
					}
				}
				rs.close();
			} catch (SQLException e) {
				throw new DAOException("レコードの取得に失敗しました", e);
			}
		}
		return borrowBeans;
	}

	public int addBook(BookBean bean) throws DAOException {
		String sqlSelectBook = "SELECT * FROM book WHERE isbn = ?";
		String sqlInsertBook = "INSERT INTO book VALUES(?,?,?,?,?,?)";
		String sqlInsertStock = "INSERT INTO stock(book_isbn) VALUES(?)";

		ResultSet rsSBook = null;
		ResultSet rsBook = null;
		ResultSet rsStock = null;

		try (Connection con = getConnection();
				PreparedStatement stSB = con.prepareStatement(sqlSelectBook);
				PreparedStatement stB = con.prepareStatement(sqlInsertBook);
				PreparedStatement stS = con.prepareStatement(sqlInsertStock);) {
			stSB.setString(1, bean.getIsbn());
			rsSBook = stSB.executeQuery();
			String isbn = "";
			while (rsSBook.next()) {
				isbn = rsSBook.getString("isbn");
			}
			if ("".contentEquals(isbn)) {
				stB.setString(1, bean.getIsbn());
				stB.setString(2, bean.getName());
				stB.setInt(3, bean.getClassId());
				stB.setString(4, bean.getAuthor());
				stB.setString(5, bean.getPublisher());
				stB.setDate(6, bean.getReleaseDate());
				stB.executeQuery();
			}
			stS.setString(1, bean.getIsbn());
			int rows = stS.executeUpdate();
			return rows;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました", e);
		} finally {
			try {
				if (rsSBook != null) {
					rsSBook.close();
				}
				if (rsBook != null)
					rsBook.close();
				if (rsStock != null)
					rsStock.close();

			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("リソースの開放に失敗しました", e);
			}
		}

	}

	public BookBean searchIsbn(String isbn) throws DAOException {
		String sqlSelectFromBook = "select * from book where isbn=?";

		ResultSet rsBook = null;
		BookBean bookBean = new BookBean();

		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sqlSelectFromBook)) {
			st.setString(1, isbn);
			rsBook = st.executeQuery();
			while (rsBook.next()) {
				String bookIsbn = rsBook.getString("isbn");
				String bookName = rsBook.getString("name");
				int bookClassId = rsBook.getInt("class_id");
				String bookAuthor = rsBook.getString("author");
				String bookPublisher = rsBook.getString("publisher");
				java.sql.Date bookReleaseDate = rsBook.getDate("release_date");
				bookBean = new BookBean(bookIsbn, bookName, bookClassId,
						bookAuthor, bookPublisher, bookReleaseDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました", e);
		} finally {
			try {
				if (rsBook != null)
					rsBook.close();

			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("リソースの開放に失敗しました", e);
			}
		}
		return bookBean;
	}
}
