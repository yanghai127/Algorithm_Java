package 贪心与动态规划;

import java.util.Scanner;

public class 最长递增子序列 {
	static int n;
	static int[] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n + 1];
		for (int i = 1; i <= n; i++)
			a[i] = sc.nextInt();
		int count = f();
		System.out.println(count);
		sc.close();
	}

	private static int f() {
		int ans = -1;
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++)
				if (a[i] > a[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			ans = Math.max(dp[i], ans);
		}
		return ans;
	}
}
