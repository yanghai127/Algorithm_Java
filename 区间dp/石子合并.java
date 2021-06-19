package 区间dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 石子合并 {
	// 区间合并问题
	// f[i][j]代表从第i堆到第j堆合并在一起花费的最少体力
	static int N = 302, n;
	static int[] w = new int[N];
	static int[][] f = new int[N][N];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		arr = in.readLine().split(" ");
		for (int i = 1; i <= n; i++)
			w[i] = Integer.parseInt(arr[i - 1]) + w[i - 1]; // 前缀数组
		
		for (int len = 1; len < n; len++) { // len表示i和j堆下标的差值
			for (int i = 1; i + len <= n; i++) {
				int j = i + len; // 自动得到右端点
				f[i][j] = 0x3f3f3f3f;
				for (int k = i; k < j; k++) // 必须满足k + 1 <= j
					f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j] + w[j] - w[i - 1]);
			}
		}
		System.out.println(f[1][n]);
	}
}
