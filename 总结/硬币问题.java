package 总结;

import java.util.Scanner;

public class 硬币问题 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n + 1];
		int[] a = new int[] { 1, 2, 5 };
		dp[0] = 1;
		for (int i = 0; i < a.length; i++)
			for (int j = a[i]; j <= n; j++)
				dp[j] += dp[j - a[i]];
		System.out.println(dp[n]);
		sc.close();
	}
}
