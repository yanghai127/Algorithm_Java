package 贪心与动态规划;

import java.util.Scanner;
import java.util.TreeSet;

/*
求最长公共子序列
13456778
357486782
*/
public class LCS {
	static String str1, str2;
	static int[][] dp;
	static TreeSet<String> set = new TreeSet<String>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str1 = sc.nextLine();
		str2 = sc.nextLine();
		int count = dp();
		System.out.println(count);
		set.forEach(obj -> System.out.println(obj));
		sc.close();
	}

	private static int dp() {
		int l1 = str1.length();
		int l2 = str2.length();
		dp = new int[l1 + 1][l2 + 1];
		for (int i = 1; i <= l1; i++)
			for (int j = 1; j <= l2; j++)
				if (str1.charAt(i - 1) == str2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
		f(l1, l2, new String());
		return dp[l1][l2];
	}

	private static void f(int i, int j, String str) {
		while (i > 0 && j > 0) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				str += str1.charAt(i - 1);
				i--;
				j--;
			} else {
				if (dp[i - 1][j] > dp[i][j - 1])
					i--;
				else if (dp[i - 1][j] < dp[i][j - 1])
					j--;
				else {
					f(i - 1, j, str);
					f(i, j - 1, str);
					return;
				}
			}
		}
		StringBuffer sB = new StringBuffer(str).reverse();
		set.add(sB.toString());
	}
}
