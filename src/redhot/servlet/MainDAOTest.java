package redhot.servlet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainDAOTest extends MainDAO {

	@Test
	void test() {
		MainDAO dao = new MainDAO();
		Assertions.assertEquals(111111, dao.getBorrowNum(111111));
	}

	@Test
	void test1() {
		MainDAO dao = new MainDAO();
		Assertions.assertEquals(true, dao.isLate());
	}

	@Test
	void test2() {
		MainDAO dao = new MainDAO();
		Assertions.assertEquals("hello", dao.getBookStatus(111));
	}

}
