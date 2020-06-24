package redhot.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import redhot.bean.MemberBean;

class MemberDAOTest {

	@Test
	@DisplayName("checkLogin")
	void test() throws DAOException {
		MemberDAO dao = new MemberDAO();

		Assertions.assertEquals(true, dao.checkLogin(1, "himitu"));

	}

	@Test
	@DisplayName("search")
	void test2() throws DAOException {
		MemberDAO dao = new MemberDAO();

		//		Assertions.assertEquals(null, dao.searchBook("9788281642674"));

		List<MemberBean> list = dao.searchMember(1, "村野", "翔太", "神奈川県川崎市", "0802222999", "1996-01-18",
				"smurano@gmail.com", false);
		MemberBean[] b = new MemberBean[list.size()];
		for (int i = 0; i < list.size(); i++) {
			b[i] = list.get(i);
			System.out.println(b[i].getId() + ":" + b[i].getLastName() + ":" + b[i].getFirstName() + ":"
					+ b[i].getAddress() + ":");
		}
	}

}
