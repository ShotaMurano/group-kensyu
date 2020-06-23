package redhot.tool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UniversalToolTest {

	//	@Test
	//	@DisplayName("booleanのTrueを返す")
	//	void test() {
	//		Assertions.assertEquals(true, UniversalTool.isUserUsable());
	//	}
	@Test
	@DisplayName("引数の合計が5より小さければbooleanのTrueを返す")
	void test() {
		Assertions.assertEquals(false, UniversalTool.isUserUsable(2, 4));
	}

}
