package 总结;

import java.util.Scanner;

// 卡特兰数
public class 合法括号 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[] = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= i; j++)
				dp[j] += dp[j - 1];
		System.out.println(dp[n]);
		sc.close();
	}
}
