package redhot.dao;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainDAOTest extends MainDAO {

	//	@Test
	//	@DisplayName("Dataベースに接続できるかの疎通テスト")
	//	void test() {
	//		MainDAO dao = new MainDAO();
	//		try {
	//			Assertions.assertEquals(1, dao.getSqlResult(111111));
	//		} catch (DAOException e) {
	//			fail();
	//			e.printStackTrace();
	//		}
	//		return;
	//	}

	//	@Test
	//	void test1() {
	//		MainDAO dao = new MainDAO();
	//		Assertions.assertEquals(true, dao.isLate());
	//	}

	//	@Test
	//	void test2() {
	//		MainDAO dao = new MainDAO();
	//		Assertions.assertEquals("hello", dao.getBookStatus(111));
	//	}

	@Test
	@DisplayName("貸出数を取得できるかの確認（ユーザID 1番の人）")
	void test3() {
		MainDAO dao = new MainDAO();
		try {
			Assertions.assertEquals(3, dao.getBorrowNum(1));
		} catch (DAOException e) {
			fail();
			e.printStackTrace();
		}
		return;
	}

	@Test
	@DisplayName("貸出数を取得できるかの確認（ユーザIDがない人）")
	void test4() {
		MainDAO dao = new MainDAO();
		try {
			Assertions.assertEquals(0, dao.getBorrowNum(2));
		} catch (DAOException e) {
			fail();
			e.printStackTrace();
		}
		return;
	}

	@Test
	@DisplayName("貸出数を取得できるかの確認（ユーザIDがマイナスの値の人）")
	void test5() {
		MainDAO dao = new MainDAO();
		try {
			Assertions.assertEquals(0, dao.getBorrowNum(-1));
		} catch (DAOException e) {
			fail();
			e.printStackTrace();
		}
		return;
	}

	@Test
	@DisplayName("予約数を取得できるかの確認（ユーザID 1番の人）")
	void test6() {
		MainDAO dao = new MainDAO();
		try {
			Assertions.assertEquals(1, dao.getPreorderNum(1));
		} catch (DAOException e) {
			fail();
			e.printStackTrace();
		}
		return;
	}

	@Test
	@DisplayName("予約数を取得できるかの確認（ユーザIDがない人）")
	void test7() {
		MainDAO dao = new MainDAO();
		try {
			Assertions.assertEquals(0, dao.getPreorderNum(2));
		} catch (DAOException e) {
			fail();
			e.printStackTrace();
		}
		return;
	}

	@Test
	@DisplayName("予約数を取得できるかの確認（ユーザIDがマイナスの人）")
	void test8() {
		MainDAO dao = new MainDAO();
		try {
			Assertions.assertEquals(0, dao.getPreorderNum(-1));
		} catch (DAOException e) {
			fail();
			e.printStackTrace();
		}
		return;
	}

	@Test
	@DisplayName("本のステータスを取得できるかの確認（Stockテーブルのステ‐タスが'exist'の場合）")
	void test9() {
		MainDAO dao = new MainDAO();
		try {
			Assertions.assertEquals("exist", dao.getBookStatus(1));
		} catch (DAOException e) {
			fail();
			e.printStackTrace();
		}
		return;
	}

	@Test
	@DisplayName("本のステータスを取得できるかの確認（Stockテーブルのステ‐タスが'none'の場合）")
	void test10() {
		MainDAO dao = new MainDAO();
		try {
			Assertions.assertEquals("none", dao.getBookStatus(5));
		} catch (DAOException e) {
			fail();
			e.printStackTrace();
		}
		return;
	}

	@Test
	@DisplayName("本のステータスを取得できるかの確認（StockIDがなかった場合）")
	void test11() {
		MainDAO dao = new MainDAO();
		try {
			Assertions.assertEquals("", dao.getBookStatus(6));
		} catch (DAOException e) {
			return;
		}
		fail();
	}

}
