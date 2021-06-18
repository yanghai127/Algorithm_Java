package 总结;

import java.util.Scanner;
import java.util.TreeSet;

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
	static int[][] dp;
	static TreeSet<String> set = new TreeSet<>();

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
		set.forEach(obj -> System.out.println(obj));
		sc.close();
	}

	private static int f() {
//		int[] dp = new int[W + 1];
//		for (int i = 1; i <= n; i++)
//			for (int j = W; j >= w[i]; j--)
//					dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
//		return dp[W];
		dp = new int[n + 1][W + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= W; j++) {
				if (j >= w[i]) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		dp(n, W, new String());
		return dp[n][W];
	}

	private static void dp(int i, int j, String str) {
		while (i > 0 && j > 0) {
			if (dp[i][j] != dp[i - 1][j]) {
				str += (i + "");
				i--;
				j -= w[i + 1];
			} else {
				i--;
			}
		}
		StringBuilder sb = new StringBuilder(str).reverse();
		set.add(sb.toString());
	}
}
