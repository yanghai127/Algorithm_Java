package 随便写写;

import java.util.Scanner;

public class 编辑距离 {
	// 循序而渐进，厚积而薄发
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		int n1 = a.length();
		int n2 = b.length();
		int[][] dp = new int[n1 + 1][n2 + 1];
		for (int i = 1; i <= n2; i++)
			dp[0][i] = dp[0][i - 1] + 1;
		for (int i = 1; i <= n1; i++)
			dp[i][0] = dp[i - 1][0] + 1;
		for (int i = 1; i <= n1; i++)
			for (int j = 1; j <= n2; j++)
				if (a.charAt(i - 1) == b.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
		System.out.println(dp[n1][n2]);
		sc.close();
	}
}
