package redhot.dao;

import java.sql.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberDAOTest {

	@Test
	@DisplayName("checkLogin")
	void test() throws DAOException {
		MemberDAO dao = new MemberDAO();

		Assertions.assertEquals(true, dao.checkLogin(1, "himitu"));

	}

	//	@Test
	//	@DisplayName("search")
	//	void test2() throws DAOException {
	//		MemberDAO memberDao = new MemberDAO();
	//
	//		//		Assertions.assertEquals(null, dao.searchBook("9788281642674"));
	//		List<MemberBean> list = memberDao.searchMember("1", "村野", "翔太", "神奈川県川崎市", "0802222999", "1996-01-18",
	//				"smurano@gmail.com", "0");
	//		MemberBean[] b = new MemberBean[list.size()];
	//		for (int i = 0; i < list.size(); i++) {
	//			b[i] = list.get(i);
	//			System.out.println(b[i].getId() + ":" + b[i].getLastName() + ":" + b[i].getFirstName() + ":"
	//					+ b[i].getAddress() + ":");
	//		}
	//	}
	//	@Test
	//	@DisplayName("search")
	//	void test3() throws DAOException {
	//		MemberDAO dao = new MemberDAO();
	//		Assertions.assertEquals(1,
	//				dao.searchMember("", "河村", "", "", "", "", "", "0").size());
	//	}

	@Test
	@DisplayName("search")
	void test4() throws DAOException {
		MemberDAO dao = new MemberDAO();

		Assertions.assertEquals(1,
				dao.addMember("内野", "翔太", "神奈川県川崎市", "0802222999", Date.valueOf("1996-01-18"), "murano@gmail.com"));

	}

}
