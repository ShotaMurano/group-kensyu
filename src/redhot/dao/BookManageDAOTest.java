package redhot.dao;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class BookManageDAOTest {

	@Test
	@DisplayName("ISBN番号での検索")
	public void test() throws DAOException {
		BookManageDAO dao = new BookManageDAO();
		Assertions.assertEquals("9788281642675",
				dao.searchBook("9788281642675", "", "9", "", "新潮文庫", "").get(0).getBookIsbn());
	}

}
