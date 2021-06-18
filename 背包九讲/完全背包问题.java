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
public class 完全背包问题 {
	static int W, n;
	static int[] w, v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		W = sc.nextInt();
		w = new int[n + 1];
		v = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		int max_value = f();
		System.out.println(max_value);
		sc.close();
	}

	private static int f() {
		int[] dp = new int[W + 1];
		for (int i = 1; i <= n; i++)
			for (int j = w[i]; j <= W; j++)
				dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
		return dp[W];
	}
}
