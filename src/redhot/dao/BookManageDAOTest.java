package redhot.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import redhot.bean.BookBean;
import redhot.bean.BorrowBean;

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

	//	@Test
	//	@DisplayName("全検索")
	//	public void test4() throws DAOException {
	//		BookManageDAO dao = new BookManageDAO();
	//		Assertions.assertEquals(6,
	//				dao.searchBook("", "", "", "", "", "").size());
	//	}
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

	//	@Test
	//	@DisplayName("今日の日付+10日の取得")
	//	public void test3() {
	//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //年月日にフォーマットする用
	//		LocalDateTime ldt = LocalDateTime.now();
	//		LocalDateTime l_date = ldt.plusDays(10);
	//		Date date3 = Date.from(l_date.toInstant(ZoneId.systemDefault().getRules().getOffset(l_date)));
	//		String day_later10_format = dateFormat.format(date3);
	//		Assertions.assertEquals("2020-07-05", day_later10_format);
	//	}

	@Test
	@DisplayName("今日の日付+10日の取得")
	public void test10() {
		try {
			BookManageDAO dao = new BookManageDAO();
			BookBean bean;
			bean = dao.searchIsbn("9788281642674");
			Assertions.assertEquals("9788281642674", bean.getIsbn());
		} catch (DAOException e) {
			e.printStackTrace();
			fail();
		}
	}

	//	@Test
	//	@DisplayName("貸出登録したIDが取得できるかの確認（1冊）")
	//	public void test5() throws DAOException {
	//		BookManageDAO dao = new BookManageDAO();
	//		String[] book_id = new String[1];
	//		book_id[0] = "1";
	//		int member_id = 1;
	//		List<BorrowBean> list = dao.borrowBook(member_id, book_id);
	//		Assertions.assertEquals(24, list.get(0).getId());
	//
	//	}

	//	@Test
	//	@DisplayName("貸出登録したIDが取得できるかの確認（2冊）")
	//	public void test6() throws DAOException {
	//		BookManageDAO dao = new BookManageDAO();
	//		String[] book_id = new String[2];
	//		book_id[0] = "1";
	//		book_id[1] = "2";
	//		int member_id = 1;
	//		List<BorrowBean> list = dao.borrowBook(member_id, book_id);
	//		Assertions.assertEquals(22, list.get(0).getId());
	//
	//	}

	//	@Test
	//	@DisplayName("貸出登録したIDが取得できるかの確認（3冊）")
	//	public void test6() throws DAOException {
	//		BookManageDAO dao = new BookManageDAO();
	//		String[] book_id = new String[3];
	//		book_id[0] = "1";
	//		book_id[1] = "2";
	//		book_id[2] = "3";
	//		int member_id = 1;
	//		List<BorrowBean> list = dao.borrowBook(member_id, book_id);
	//		Assertions.assertEquals(29, list.get(0).getId());
	//		Assertions.assertEquals(30, list.get(1).getId());
	//		Assertions.assertEquals(31, list.get(2).getId());
	//	}

	//	@Test
	//	@DisplayName("貸出登録したIDが取得できるかの確認（4冊）")
	//	public void test6() throws DAOException {
	//		BookManageDAO dao = new BookManageDAO();
	//		String[] book_id = new String[4];
	//		book_id[0] = "1";
	//		book_id[1] = "2";
	//		book_id[2] = "3";
	//		book_id[3] = "4";
	//		int member_id = 1;
	//		List<BorrowBean> list = dao.borrowBook(member_id, book_id);
	//		Assertions.assertEquals(32, list.get(0).getId());
	//		Assertions.assertEquals(33, list.get(1).getId());
	//		Assertions.assertEquals(34, list.get(2).getId());
	//		Assertions.assertEquals(35, list.get(3).getId());
	//	}

	//	@Test
	//	@DisplayName("貸出登録したIDが取得できるかの確認（5冊）")
	//	public void test6() throws DAOException {
	//		BookManageDAO dao = new BookManageDAO();
	//		String[] book_id = new String[5];
	//		book_id[0] = "1";
	//		book_id[1] = "2";
	//		book_id[2] = "3";
	//		book_id[3] = "4";
	//		book_id[4] = "5";
	//		int member_id = 1;
	//		List<BorrowBean> list = dao.borrowBook(member_id, book_id);
	//		Assertions.assertEquals(36, list.get(0).getId());
	//		Assertions.assertEquals(37, list.get(1).getId());
	//		Assertions.assertEquals(38, list.get(2).getId());
	//		Assertions.assertEquals(39, list.get(3).getId());
	//		Assertions.assertEquals(40, list.get(4).getId());
	//	}

	//	@Test
	//	@DisplayName("返却した本の貸出IDを取得できるかの確認")
	//	public void test7() throws DAOException {
	//		BookManageDAO dao = new BookManageDAO();
	//		List<String> book_id = new ArrayList<String>();
	//		book_id.add("5");
	//		int member_id = 1;
	//		List<BorrowBean> list = dao.returnBook(member_id, book_id);
	//		Assertions.assertEquals(77, list.get(0).getId());
	//	}

	@Test
	@DisplayName("本の資料IDが1つも一致しなかったときにListのサイズが0になるかを確認")
	public void test8() throws DAOException {
		BookManageDAO dao = new BookManageDAO();
		List<String> book_id = new ArrayList<String>();
		book_id.add("5");
		int member_id = 1;
		List<BorrowBean> list = dao.returnBook(member_id, book_id);
		Assertions.assertEquals(0, list.size());
	}

}