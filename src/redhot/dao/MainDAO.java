package redhot.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainDAO {

	private Connection con;
	final private String url = "jdbc:postgresql:webbook";
	final private String user = "student";
	final private String pass = "himitu";

	protected Connection getConnection() throws DAOException {
		if (con != null) {
			return con;
		}
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, pass);
			return con;
		} catch (Exception e) {
			throw new DAOException("接続に失敗しました", e);
		}
	}

	//ユーザIDを入れて、借りてる本の数を返す
	public int getBorrowNum(int id) throws DAOException {
		String sql2 = "SELECT COUNT(id) as count FROM borrow WHERE user_id=? AND return_date IS NULL";
		int count = 0;
		ResultSet rs = null;
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sql2);) {
			st.setInt(1, id);
			rs = st.executeQuery();
			rs.next();
			count = rs.getInt("count");

			return count;

		} catch (SQLException e) {
			throw new DAOException("レコードの取得に失敗しました", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new DAOException("リソースの開放に失敗しました", e);
			}
		}
	}

	//ユーザIDを入れて、予約している本の数を返す
	public int getPreorderNum(int id) throws DAOException {
		String sql = "SELECT * FROM preorder WHERE user_id=?";
		int count = 0;
		ResultSet rs = null;
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, id);
			rs = st.executeQuery();
			while (rs.next()) {
				count++;
			}
			return count;
		} catch (SQLException e) {
			throw new DAOException("レコードの取得に失敗しました", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new DAOException("リソースの開放に失敗しました", e);
			}
		}

	}

	//	ユーザの延滞があるかを
	public boolean isLate(int id) throws DAOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //年月日にフォーマットする用
		Date today = new Date();
		String today_format = dateFormat.format(today); //yyyy-MM-ddの形にフォーマットしている
		String sql = "SELECT will_return_date FROM borrow WHERE id=?";
		ResultSet rs = null;
		System.out.println();

		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, id);
			rs = st.executeQuery();
			rs.next();
			String return_day = rs.getString("will_return_date");
			Date return_day_parse = dateFormat.parse(return_day);
			Date today_parse = dateFormat.parse(today_format);

			if (return_day_parse.after(today_parse) == true) {
				return false; //延滞がない
			} else if (return_day_parse.equals(today_parse)) {
				return false; //延滞がない
			} else {
				return true; //延滞がある
			}

		} catch (SQLException e) {
			throw new DAOException("レコードの取得に失敗しました", e);
		} catch (ParseException e) {
			throw new DAOException("レコードの取得に失敗しました", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new DAOException("リソースの開放に失敗しました", e);
			}
		}
	}

	//
	public String getBookStatus(int stock_id) throws DAOException {
		String sql = "SELECT status FROM stock WHERE id=?";
		String book_status = null;
		ResultSet rs = null;
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, stock_id);
			rs = st.executeQuery();
			rs.next();
			book_status = rs.getString("status");
			return book_status;
		} catch (SQLException e) {
			throw new DAOException("レコードの取得に失敗しました", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new DAOException("リソースの開放に失敗しました", e);
			}
		}
	}
}

//テスト用メソッド
//	public int getSqlResult(int id) throws DAOException {
//		String sql = "SELECT * FROM users";
//		try (Connection con = getConnection();
//				PreparedStatement st = con.prepareStatement(sql);) {
//			ResultSet rs = st.executeQuery();
//			rs.next();
//			System.out.println(rs.getInt("id"));
//			return rs.getInt("id");
//		} catch (SQLException e) {
//			throw new DAOException("レコードの取得に失敗しました", e);
//		}
//
//	}

//datebaseに格納されているDateを表示
//	public String returnDate(int id) throws DAOException {
//		String sql = "SELECT borrow_date FROM borrow where id=?";
//		ResultSet rs = null;
//
//		try (Connection con = getConnection();
//				PreparedStatement st = con.prepareStatement(sql);) {
//			st.setInt(1, id);
//			rs = st.executeQuery();
//			rs.next();
//			String d1 = rs.getString("borrow_date");
//			return d1;
//		} catch (SQLException e) {
//			throw new DAOException("レコードの取得に失敗しました", e);
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//			} catch (SQLException e) {
//				throw new DAOException("リソースの開放に失敗しました", e);
//			}
//		}
//	}
