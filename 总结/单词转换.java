package 总结;

import java.util.Scanner;

/*
测试用例
horse
ros
3
 */
public class 单词转换 {
	// 有点像LCS
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int count = f(s1, s2);
		System.out.println(count);
		sc.close();
	}

	public static int f(String word1, String word2) {
		int n1 = word1.length();
		int n2 = word2.length();
		int[][] dp = new int[n1 + 1][n2 + 1];
		// dp[0][0...n2]的初始值
		for (int j = 1; j <= n2; j++)
			dp[0][j] = dp[0][j - 1] + 1;
		// dp[0...n1][0] 的初始值
		for (int i = 1; i <= n1; i++)
			dp[i][0] = dp[i - 1][0] + 1;
		// 通过公式推出 dp[n1][n2]
		for (int i = 1; i <= n1; i++)
			for (int j = 1; j <= n2; j++)
				// 如果 word1[i] 与 word2[j] 相等。第 i 个字符对应下标是 i-1
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
		return dp[n1][n2];
	}
}
