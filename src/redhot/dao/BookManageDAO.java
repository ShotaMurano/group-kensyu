package redhot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import redhot.bean.BookBean;
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

		if (whereList != null || whereList.size() != 0) {
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
}