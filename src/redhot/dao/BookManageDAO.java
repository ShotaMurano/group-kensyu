package redhot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import redhot.bean.BookBean;
import redhot.bean.StockBean;

public class BookManageDAO extends MainDAO {
	private Connection con;

	public BookManageDAO() throws DAOException {
		getConnection();
	}

	//	public List searchBook(int isbn, String name , int classId, String author,
	//			String publisher, java.sql.Date releaseDate) throws DAOException {
	public List<StockBean> searchBook(String isbn) throws DAOException {
		Connection con = super.getConnection();

		PreparedStatement st1 = null;
		PreparedStatement st2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;

		try {
			// Bookテーブルに実行するSQL文
			String sql1 = "select * from book where isbn = ? ";
			// Stockテーブルに実行するSQL文
			String sql2 = "select * from stock where  book_isbn = ? ";
			st1 = con.prepareStatement(sql1);
			st2 = con.prepareStatement(sql2);

			//BookテーブルのSQL文に値の設定
			st1.setString(1, isbn);
			// SQL実行
			rs1 = st1.executeQuery();

			// Bookテーブルの検索結果から対象レコードのISBN番号を取得、
			// 取得したISBN番号でStockテーブルにSQL文実行
			//			List<BookBean> bookBeanList = new ArrayList<BookBean>();
			List<StockBean> list = new ArrayList<StockBean>();
			while (rs1.next()) {
				String bookTableIsbn = rs1.getString("isbn");
				String bookName = rs1.getString("name");
				int bookClassId = rs1.getInt("class_id");
				String bookAuthor = rs1.getString("author");
				String bookPublisher = rs1.getString("publisher");
				java.sql.Date bookReleaseDate = rs1.getDate("release_date");
				// このbbeanをstockのbookbeanに入れてやる？
				BookBean bbean = new BookBean(bookTableIsbn, bookName, bookClassId,
						bookAuthor, bookPublisher, bookReleaseDate);
				//				bookBeanList.add(bbean);
				// ここから：取得したISBN番号でStockテーブルにSQL文実行
				st2.setString(1, isbn);
				rs2 = st2.executeQuery();
				while (rs2.next()) {
					int id = rs2.getInt("id");
					String bookIsbn = rs2.getString("book_isbn");
					java.sql.Date inDate = rs2.getDate("in_date");
					java.sql.Date outDate = rs2.getDate("out_date");
					String status = rs2.getString("status");
					StockBean sbean = new StockBean(id, bookIsbn, inDate,
							outDate, status, bbean);
					list.add(sbean);
				}
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました", e);
		} finally {
			try {
				if (st1 != null)
					st1.close();
				if (st2 != null)
					st2.close();
				if (rs1 != null)
					rs1.close();
				if (rs2 != null)
					rs2.close();

			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("リソースの開放に失敗しました", e);
			}
		}

	}

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
}
//UPDATE stock SET out_date='2020-06-24',status='none' WHERE id=1;
//	public Short searchBook() {
//		// TODO 自動生成されたメソッド・スタブ
//		return null;
//	}
