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
			con = getConnection();
		}
		String sql = "SELECT password FROM users WHERE id=?";

		String database_password = "";

		try (PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {

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

		String sql = "INSERT INTO users(last_name,first_name,address,tellphone,birthday,mail_address) VALUES(?,?,?,?,?,?)";
		try (Connection con = getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

			st.setString(1, input_lastName);
			st.setString(2, input_firstName);
			st.setString(3, input_address);
			st.setString(4, input_tellphone);
			st.setDate(5, input_birthday);
			st.setString(6, input_mailAddress);

			int rows = st.executeUpdate();
			return rows;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。", e);
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

	public List<MemberBean> searchMember(String id, String input_lastName, String input_firstName,
			String input_address, String input_tellphone,
			String input_birthday,
			String input_mailAddress, String isOut) throws DAOException {
		// Bookテーブルに実行するSQL文
		String sqlSelectFromUsers = "select * from users";
		ArrayList<String> whereList = new ArrayList<String>();
		ArrayList<String> valueList = new ArrayList<String>();
		ArrayList<Integer> valueIntList = new ArrayList<Integer>();

		if (!"".equals(input_lastName)) {
			whereList.add("last_name = ?");
			valueList.add(input_lastName);
		}
		if (!"".equals(input_firstName)) {
			whereList.add("first_name = ?");
			valueList.add(input_firstName);
		}
		if (!"".equals(input_address)) {
			whereList.add("address = ?");
			valueList.add(input_address);
		}
		if (!"".equals(input_tellphone)) {
			whereList.add("tellphone = ?");
			valueList.add(input_tellphone);
		}
		if (!"".equals(input_birthday)) {
			whereList.add("birthday = ?");
			valueList.add(input_birthday);
		}
		if (!"".equals(input_mailAddress)) {
			whereList.add("mail_address = ?");
			valueList.add(input_mailAddress);
		}

		if (!"".equals(id)) {
			whereList.add("id = ?");
			valueIntList.add(Integer.parseInt(id));
		}

		if ("1".contentEquals(isOut)) {
			whereList.add("out_date IS NOT NULL");
		} else {
			whereList.add("out_date IS NULL");
		}

		if (whereList.size() != 0) {
			sqlSelectFromUsers += " WHERE " + String.join(" AND ", whereList);
		}

		ResultSet rs = null;

		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sqlSelectFromUsers)) {

			for (int i = 0; i < valueList.size(); i++) {
				st.setString(i + 1, valueList.get(i));
				System.out.println(valueList.get(i));
			}
			for (int i = valueList.size(); i < valueList.size() + valueIntList.size(); i++) {
				st.setInt(i + 1, valueIntList.get(i - valueList.size()));
				System.out.println(valueList.get(i));
			}

			rs = st.executeQuery();
			List<MemberBean> memberBeans = new ArrayList<MemberBean>();
			while (rs.next()) {
				int user_id = rs.getInt("id");
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

				MemberBean bean = new MemberBean(user_id, lastName, firstName, address, tellphone, birthday,
						mailAddress,
						password, inDate, outDate, cerUrl);
				memberBeans.add(bean);
			}

			return memberBeans;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました", e);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。", e);
			}
		}

	}

	public int updateMember(int input_id, String input_lastName, String input_firstName, String input_address,
			String input_tellphone, Date input_birthday, String input_mailAddress, Date input_outDate)
			throws DAOException {
		if (con == null)
			getConnection();

		String sql = "UPDATE users SET last_name=?,first_name=?,address=?,tellphone=?,birthday=?,mail_address=?,out_date=? WHERE id=?";

		try (PreparedStatement st = con.prepareStatement(sql)) {
			st.setString(1, input_lastName);
			st.setString(2, input_firstName);
			st.setString(3, input_address);
			st.setString(4, input_tellphone);
			st.setDate(5, input_birthday);
			st.setString(6, input_mailAddress);
			st.setDate(7, input_outDate);
			st.setInt(8, input_id);

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
