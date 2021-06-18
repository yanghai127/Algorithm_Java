package 随便写写;

import java.util.Arrays;
import java.util.Scanner;

public class 机器人走方格 {
	static int m, n, a[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		a = new int[m + 1][n + 1];
		int count = f();
		System.out.println(count);
		sc.close();
	}

	private static int f() {
		int dp[] = new int[n + 1];
		Arrays.fill(dp, 1);
		for (int i = 2; i <= m; i++)
			for (int j = 2; j <= n; j++)
				dp[j] += dp[j - 1];
		return dp[n];
	}
}
