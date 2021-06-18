package 模拟赛3_20;

import java.util.Scanner;

public class D {
	/*
	 * dfs、剪枝、回溯、动态规划、格式控制，综合性较强，考察问题的分解能力 
	 * 先用dfs加剪枝回溯求出所有可能的邮票价格组合，再用dp数组分别验证求最值
	 * 虽然dp数组很巧妙，但dfs耗时严重，总的来说有点暴力
	 */
	static int[] a, b;
	static int n, k, max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		a = new int[k];
		b = new int[k];
		a[0] = 1;
		dfs(1);
		for (int i = 0; i < k; i++)
			System.out.print(b[i] + " ");
		System.out.println("\nMAX=" + max);
		sc.close();
	}

	private static void dfs(int i) {
		if (i == k) {
			cheak();
			return;
		}
		for (int j = a[i - 1] + 1; j <= a[i - 1] * n + 1; j++) {
			a[i] = j;
			dfs(i + 1);
		}
	}

	private static void cheak() {
		// 下标代表邮资，值代表张数
		int dp[] = new int[1000];
		dp[0] = 0;
		int i = 0;
		while (dp[i] <= n) {
			i++;
			dp[i] = 15;
			for (int j = 0; j < k && a[j] <= i; j++)
				if (dp[i - a[j]] + 1 < dp[i])
					dp[i] = dp[i - a[j]] + 1;
		}
		if (i - 1 > max) {
			max = i - 1;
			for (int j = 0; j < k; j++)
				b[j] = a[j];
		}
	}
}
