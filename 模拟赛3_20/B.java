package 模拟赛3_20;

import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		for (int i = 2; i <= n / 2; i++)
			if (cheak(i) && cheak(n - i))
				ans++;
		System.out.println(ans);
		sc.close();
	}

	private static boolean cheak(int n) {
		for (int i = 2; i * i <= n; i++)
			if (n % i == 0)
				return false;
		return true;
	}
}
