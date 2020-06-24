package redhot.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import redhot.bean.MemberBean;

public class MemberDAO extends MainDAO {

	private Connection con;

	public MemberDAO() throws DAOException {
		getConnection();
	}

	public boolean checkLogin(int id, String password) throws DAOException {
		if (con == null) {
			getConnection();
		}
		String sql = "SELECT password FROM users WHERE id=?";

		String database_password = "";

		try (PreparedStatement st = con.prepareStatement(sql);) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				st.setInt(1, id);
				database_password = rs.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。", e);
			}
		}

		if (password.contentEquals(database_password)) {
			return true;
		} else {
			return false;
		}

	}

	public int addMember(String input_lastName, String input_firstName,
			String input_address, String input_tellphone,
			Date input_birthday,
			String input_mailAddress) throws DAOException {
		if (con == null)
			getConnection();

		String sql = "INSERT INTO users(id,last_name,first_name,address,tellphone,birthday,mail_address,in_date) VALUES(?,?,?,?,?,?,?,?)";
		try (PreparedStatement st = con.prepareStatement(sql)) {

			st.setString(2, input_lastName);
			st.setString(3, input_firstName);
			st.setString(4, input_address);
			st.setString(5, input_tellphone);
			st.setDate(6, input_birthday);
			st.setString(7, input_mailAddress);

			int rows = st.executeUpdate();
			return rows;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。", e);
		} finally {
			try {
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。", e);
			}
		}
	}

	public List<MemberBean> findAll() throws DAOException {
		if (con == null) {
			getConnection();
		}

		List<MemberBean> list = new ArrayList<MemberBean>();
		String sql = "SELECT * FROM users";

		try (PreparedStatement st = con.prepareStatement(sql);) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String lastName = rs.getString("last_name");
				String firstName = rs.getString("first_name");
				String address = rs.getString("address");
				String tellphone = rs.getString("tellphone");
				String birthday = rs.getString("birthday");
				String mailAddress = rs.getString("mail_address");
				String password = rs.getString("password");
				Date inDate = rs.getDate("in_date");
				Date outDate = rs.getDate("out_date");
				String cerUrl = rs.getString("certificate");

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

	public List<MemberBean> searchMember(int input_id, String input_lastName, String input_firstName,
			String input_address, String input_tellphone,
			Date input_birthday,
			String input_mailAddress, boolean isOut) throws DAOException {
		if (con == null)
			getConnection();
		String sql = "SELECT * FROM users WHERE ? LIKE ?";
		ResultSet rs = null;
		try (PreparedStatement st = con.prepareStatement(sql)) {
			st.setString(1, "id");
			st.setInt(2, input_id);
			rs = st.executeQuery();
			List<MemberBean> list = new ArrayList<MemberBean>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String lastName = rs.getString("last_name");
				String firstName = rs.getString("first_name");
				String address = rs.getString("address");
				String tellphone = rs.getString("tellphone");
				String birthday = rs.getString("birthday");
				String mailAddress = rs.getString("mail_address");
				String password = rs.getString("password");
				Date inDate = rs.getDate("in_date");
				Date outDate = rs.getDate("out_date");
				String cerUrl = rs.getString("certificate");

				MemberBean bean = new MemberBean(id, lastName, firstName, address, tellphone, birthday, mailAddress,
						password, inDate, outDate, cerUrl);
				list.add(bean);
			}

			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました", e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。", e);
			}
		}

	}

	public int updateMember(int input_id, String input_lastName) throws DAOException {
		if (con == null)
			getConnection();

		String sql = "UPDATE users SET last_name=? WHERE id=?";

		try (PreparedStatement st = con.prepareStatement(sql)) {
			st.setString(1, "%" + input_lastName + "%");
			st.setInt(2, input_id);

			int rows = st.executeUpdate();
			return rows;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました", e);
		} finally {
			try {
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。", e);
			}
		}

	}

	private void close() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}

	}

}
