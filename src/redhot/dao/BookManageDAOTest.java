package redhot.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class BookManageDAOTest {

	//	@Test
	//	@DisplayName("ISBN番号での検索")
	//	public void test() throws DAOException {
	//		BookManageDAO dao = new BookManageDAO();
	//		Assertions.assertEquals("9788281642675",
	//				dao.searchBook("9788281642675", "", "9", "", "新潮文庫", "").get(0).getBookIsbn());
	//
	//	}

	@Test
	@DisplayName("本の更新処理が無事に終了するか確認")
	public void test1() throws DAOException {
		BookManageDAO dao = new BookManageDAO();
		try {
			Assertions.assertEquals("本を1冊廃棄しました", dao.deleteBook(2));
		} catch (DAOException e) {
			fail();
		}
		return;
	}

	@Test
	@DisplayName("本の更新処理が無事に終了するか確認")
	public void test2() throws DAOException {
		BookManageDAO dao = new BookManageDAO();
		try {
			Assertions.assertEquals("本を1冊廃棄しました", dao.deleteBook(2));
		} catch (DAOException e) {
			fail();
		}
		return;
	}

	@Test
	@DisplayName("今日の日付+10日の取得")
	public void test3() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //年月日にフォーマットする用
		LocalDateTime ldt = LocalDateTime.now();
		LocalDateTime l_date = ldt.plusDays(10);
		Date date3 = Date.from(l_date.toInstant(ZoneId.systemDefault().getRules().getOffset(l_date)));
		String day_later10_format = dateFormat.format(date3);
		Assertions.assertEquals("2020-07-04", day_later10_format);
	}

	//	@Test
	//	@DisplayName("での検索")
	//	public void test4() throws DAOException {
	//		BookManageDAO dao = new BookManageDAO();
	//		String[] book_id = new String[2];
	//		book_id[0] = "1";
	//		book_id[1] = "1";
	//		Assertions.assertEquals("9788281642675",
	//				dao.searchBook("9788281642675", "", "9", "", "新潮文庫", "").get(0).getBookIsbn());
	//
	//	}

}