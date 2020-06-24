package redhot.dao;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import redhot.bean.StockBean;

public class BookManageDAOTest extends MainDAO {

	@Test
	@DisplayName("ISBN番号での検索")
	void test() throws DAOException {
		BookManageDAO dao = new BookManageDAO();
		//		Assertions.assertEquals(null, dao.searchBook("9788281642674"));

		List<StockBean> list = dao.searchBook("9788281642674");
		StockBean[] b = new StockBean[list.size()];
		for (int i = 0; i < list.size(); i++) {
			b[i] = list.get(i);
			System.out.println(b[i].getId() + ":" + b[i].getBookIsbn() + ":"
					+ b[i].getInDate() + ":" + b[i].getOutDate() + ":" + b[i].getStatus() + ":" + b[i].getBean());
		}
	}



}
