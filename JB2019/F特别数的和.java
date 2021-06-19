package JB2019;

import java.util.Scanner;

public class F特别数的和 {
	static int n, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 1; i <= n; i++)
			if (cheak(i))
				ans += i;
		System.out.println(ans);
		sc.close();
	}

	private static boolean cheak(int i) {
		while (i != 0) {
			int a = i % 10;
			if (a == 2 || a == 0 || a == 1 || a == 9)
				return true;
			i /= 10;
		}
		return false;
	}
}
