package 第三期;

import java.util.Scanner;

public class 上升子序列 {
	static int n, k, MOD = 1000007;
	static int[] r;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		r = new int[n];
		for (int i = 0; i < n; ++i)
			r[i] = sc.nextInt();// r = {3, 2, 7, 6, 7}
		int[][] dp = new int[n][k + 1]; // dp[i][j]表示以r[i]结尾并且长度为k的上升序列的数量，如dp[2][2]=2，因为r[2]>r[0]、r[2]>r[1]，r[0]和r[1]分别能构造一个长度为1的上升序列
		for (int i = 0; i < n; ++i)
			dp[i][1] = 1; // 每个元素都能构造出仅有自身的上升序列
		for (int i = 1; i < n; ++i) // 从左往右依次检查
			for (int j = 0; j < i; ++j) // 从左往当前位置检查，尝试去发现满足“上升”的条件
				if (r[i] > r[j]) // 发现左边存在比当前数值小的，即满足“上升”
					for (int t = 2; t <= k; ++t) // 这里的t其实可以从2开始，因为dp[j][0]永远等于0
						// r[j]能构造出dp[j][t-1]个长度为t-1的上升序列，那么r[i]就能在r[j]的基础上构造出dp[j][t-1]个长度为t的上升序列
						dp[i][t] += dp[j][t - 1]; // 记得每次都要取余，防止溢出
		int ans = 0;
		for (int i = 0; i < n; ++i)
			ans = (ans + dp[i][k]) % MOD;
		System.out.println(ans);
		sc.close();
	}
}
