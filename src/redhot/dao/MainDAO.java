package redhot.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainDAO {

	private Connection con;
	final private String url = "jdbc:postgresql:webbook";
	final private String user = "student";
	final private String pass = "himitu";
	private int id;
	private int stockid;

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

	//ユーザIDを入れて、借りてる本の数を返す
	public int getBorrowNum(int id) throws DAOException {
		String sql = "SELECT * FROM borrow where user_id=?";
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

	//ユーザIDを入れて、予約している本の数を返す
	public int getPreorderNum(int id) throws DAOException {
		String sql = "SELECT * FROM preorder where user_id=?";
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

	//ユーザの延滞があるかを
	public boolean isLate(int id) {
		return true;
	}

	public String getBookStatus(int stock_id) throws DAOException {
		String sql = "SELECT * FROM stock where id=?";

		@SuppressWarnings("unused")
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
