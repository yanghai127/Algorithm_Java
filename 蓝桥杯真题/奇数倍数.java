package 蓝桥杯真题;

public class 奇数倍数 {
	public static void main(String[] args) {
		for (int i = 2019;; i += 2019) {
			if (check(i)) {
				System.out.println(i);
				break;
			}
		}
	}

	private static boolean check(int i) {
		while (i != 0) {
			int num = i % 10;
			if (num % 2 == 0) {
				return false;
			}
			i /= 10;
		}
		return true;
	}
}
