package redhot.dao;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class BookManageDAOTest {
	//
	//	@Test
	//	@DisplayName("ISBN番号での検索")
	//	public void test() throws DAOException {
	//		BookManageDAO dao = new BookManageDAO();
	//		Assertions.assertEquals("9788281642675",
	//				dao.searchBook("9788281642675", "", "9", "", "新潮文庫", "").get(0).getBookIsbn());
	//
	//	}

	@Test
	@DisplayName("全検索")
	public void test4() throws DAOException {
		BookManageDAO dao = new BookManageDAO();
		Assertions.assertEquals(6,
				dao.searchBook("", "", "", "", "", "").size());

	}
	//
	//	@Test
	//	@DisplayName("本の更新処理が無事に終了するか確認")
	//	public void test1() throws DAOException {
	//		BookManageDAO dao = new BookManageDAO();
	//		try {
	//			Assertions.assertEquals("本を1冊廃棄しました", dao.deleteBook(2));
	//		} catch (DAOException e) {
	//			fail();
	//		}
	//		return;
	//	}
	//
	//	@Test
	//	@DisplayName("本の更新処理が無事に終了するか確認")
	//	public void test2() throws DAOException {
	//		BookManageDAO dao = new BookManageDAO();
	//		try {
	//			Assertions.assertEquals("本を1冊廃棄しました", dao.deleteBook(2));
	//		} catch (DAOException e) {
	//			fail();
	//		}
	//		return;
	//	}

}