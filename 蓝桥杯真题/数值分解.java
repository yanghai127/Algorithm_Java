package 蓝桥杯真题;

public class 数值分解 {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 1; i < 2019 / 3; i++) {
			for (int j = i + 1; j < 2019 - i; j++) {
				int k = 2019 - i - j;
				if (k > j && f(i, j, k))
					count++;
			}
		}
		System.out.println(count);
	}

	private static boolean f(int i, int j, int k) {
		while (i != 0) {
			if (i % 10 == 2 || i % 10 == 4)
				return false;
			i /= 10;
		}
		while (j != 0) {
			if (j % 10 == 2 || j % 10 == 4)
				return false;
			j /= 10;
		}
		while (k != 0) {
			if (k % 10 == 2 || k % 10 == 4)
				return false;
			k /= 10;
		}
		return true;
	}
}
