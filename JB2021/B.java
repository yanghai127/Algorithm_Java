package JB2021;

import java.util.Arrays;

public class B {
	static int a[] = new int[10];

	public static void main(String[] args) {
		Arrays.fill(a, 2021);
		for (int i = 1; i < 0x3f3f3f3f; i++) {
			if (check(i)) {
				System.out.println(i - 1);
				break;
			}
		}
	}

	private static boolean check(int n) {
		while (n != 0) {
			a[n % 10]--;
			if (a[n % 10] < 0)
				return true;
			n /= 10;
		}
		return false;
	}
}
