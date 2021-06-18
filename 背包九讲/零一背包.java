package 背包九讲;

import java.util.Scanner;

/*
6 12
4 8
6 10
2 6
2 3
5 7
1 2
*/
public class 零一背包 {
	static int n, W;
	static int[] v, w;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		W = sc.nextInt();
		v = new int[n + 1];
		w = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		int sum = f();
		System.out.println(sum);
		sc.close();
	}

	private static int f() {
		// t代表重量，n代表数量
		int[] dp = new int[W + 1];
		for (int i = 1; i <= n; i++)
			for (int j = W; j >= w[i]; j--)
				dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
		return dp[W];
//		int[][] dp = new int[n + 1][t + 1];
//		for (int i = 1; i <= n; i++)
//			for (int j = 1; j <= t; j++)
//				if (j >= w[i])
//					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
//				else
//					dp[i][j] = dp[i - 1][j];
//		return dp[n][t];
	}
}
