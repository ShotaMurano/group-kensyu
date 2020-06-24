package redhot.dao;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import redhot.bean.StockBean;

public class BookManageDAOTest {

	@Test
	@DisplayName("ISBN番号での検索")
	public void test() throws DAOException {
		BookManageDAO dao = new BookManageDAO();
		Assertions.assertEquals("9788281642675",
				dao.searchBook("9788281642675", "", "9", "", "新潮文庫", "").get(0).getBookIsbn());

	}



}
