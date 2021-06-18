package 第四期;

import java.util.Scanner;

public class 递增子序列 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] rv = new int[n];
		for (int i = 0; i < n; ++i)
			rv[i] = sc.nextInt();
		int[][] dp = new int[n][2];
		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j)
				if (rv[i] > rv[j])
					dp[i][0] += 1;
		}
		for (int i = 2; i < n; ++i) {
			dp[i][1] = dp[i - 1][1];
			for (int j = 0; j < i; ++j)
				if (rv[i] > rv[j])
					dp[i][1] += dp[j][0];
		}
		System.out.println(dp[n - 1][1]);
		sc.close();
	}
}
