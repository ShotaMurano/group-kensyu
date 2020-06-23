package redhot.tool;

public class UniversalTool {
	public static boolean isUserUsable(int borrowNum, int preorderNum) {
		if (borrowNum + preorderNum < 5) {
			return true;
		} else {
			return false;
		}
	}

}
