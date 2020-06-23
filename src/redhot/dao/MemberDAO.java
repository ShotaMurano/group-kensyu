package redhot.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import redhot.bean.MemberBean;
import redhot.servlet.DAOException;

public class MemberDAO {

	private Connection con;

	public MemberDAO() throws DAOException {
		getConnection();
	}

	public void getConnection() throws DAOException {
		String url = "jdbc:postgresql:webbook";
		String user = "student";
		String pass = "himitu";
		try {
			//データベースへの接続
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("接続に失敗しました。", e);
		}

	}

	public boolean checkLogin(int id, String password) {
		return false;

	}

	public List<MemberBean> findAll() throws DAOException {
		if (con == null) {
			getConnection();
		}

		List<MemberBean> list = new ArrayList<MemberBean>();
		String sql = "SELECT * FROM user";

		try (PreparedStatement st = con.prepareStatement(sql);) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				String address = rs.getString("address");
				String tellphone = rs.getString("tellphone");
				String birthday = rs.getString("birthday");
				String mailAddress = rs.getString("mailAddress");
				String password = rs.getString("password");
				Date inDate = rs.getDate("inDate");
				Date outDate = rs.getDate("outDate");
				String cerUrl = rs.getString("cerUrl");

				MemberBean bean = new MemberBean(id, lastName, firstName, address, tellphone, birthday, mailAddress,
						password, inDate, outDate, cerUrl);
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。", e);
		} finally {
			try {
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。", e);
			}
		}

		return list;
	}

	private void close() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}

	}

}
