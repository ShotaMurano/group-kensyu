package redhot.dao;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

class BookManageDAOTest {

	@Test
	@DisplayName("ISBN番号での検索")
	void test() throws DAOException {
		BookManageDAO dao = new BookManageDAO();
		Assertions.assertEquals(null, dao.searchBook("9788281642674"));
	}

}
