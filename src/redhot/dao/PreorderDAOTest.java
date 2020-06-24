package redhot.dao;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PreorderDAOTest extends MainDAO {

	@Test
	@DisplayName("書籍の合計が5冊以上の場合は借りられない。")
	void test() {
		PreorderDAO dao;
		try {
			dao = new PreorderDAO();
			Assertions.assertEquals(dao.addPreorderQueue(2, 1), 0);
		} catch (DAOException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	@DisplayName("書籍の合計が5冊以上の場合は借りられない。")
	void test2() {
		PreorderDAO dao;
		try {
			dao = new PreorderDAO();
			Assertions.assertEquals(dao.addPreorderQueue(2, 1), 0);
		} catch (DAOException e) {
			e.printStackTrace();
			fail();
		}
	}

	//	@BeforeAll
	//	@DisplayName("値の挿入")
	//	void test2() throws DAOException {
	//		PreorderDAO dao = new PreorderDAO();
	//
	//		String sql = "INSERT INTO preorder VALUES(?,?,?)";
	//		Date date = new Date(100);
	//
	//		try (Connection con = getConnection();
	//				PreparedStatement st = con.prepareStatement(sql);) {
	//			st.setInt(1, 1);
	//			st.setInt(2, 2);
	//			st.setDate(3, date);
	//
	//			int rows = st.executeUpdate();
	//
	//		} catch (Exception e) {
	//			throw new DAOException("リソースの開放に失敗しました。", e);
	//		}
	//	}

}
