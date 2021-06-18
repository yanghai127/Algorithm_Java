package 蓝桥杯真题;

public class 质数 {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 2; i < Integer.MAX_VALUE; i++) {
			if (cheak(i)) {
				count++;
			}
			if (count == 2019) {
				System.out.println(i);
				break;
			}
		}
	}

	private static boolean cheak(int n) {
		// 不能写成i*i，小心i溢出
		for (int i = 2; i <= n/i; i++)
			if (n % i == 0)
				return false;
		return true;
	}
}
