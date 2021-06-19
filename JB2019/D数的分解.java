package JB2019;

public class D数的分解 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i < 2019; i++) {
			if (!check(i))
				continue;
			for (int j = i + 1; j < 2019 - i - j; j++) {
				int k = 2019 - i - j;
				if (check(j) && check(k))
					sum++;
			}
		}
		System.out.println(sum);
	}

	public static boolean check(int n) {
		while (n != 0) {
			if (n % 10 == 2 || n % 10 == 4)
				return false;
			else
				n /= 10;
		}
		return true;
	}
}
