package 基础要打牢;

public class 找素数 {
	/*
	 * 10e5次方，直接暴力
	 */
	public static void main(String[] args) {
		int count =0;
		for (int i = 2; i < Integer.MAX_VALUE; i++) {
			if (check(i)) {
				count++;
				if (count==100002) {
					System.out.println(i);
					break;
				}
			}
		}
	}

	private static boolean check(int a) {
		for (int i = 2; i <= a/i; i++) {
			if (a%i==0) {
				return false;
			}
		}
		return true;
	}
}
