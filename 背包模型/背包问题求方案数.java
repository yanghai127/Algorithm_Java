package 背包模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 背包问题求方案数 {
	// 一维，不超过，最大值方案数，01背包
	// f[i] 用来存储背包容积为 i 时的最佳方案的总价值，
	// cnt[i]为背包容积为 i 时总价值为最佳的方案数
	static int N = 1010;
	static int MOD = (int) 1e9 + 7;
	static int[] f = new int[N], cnt = new int[N];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);

		Arrays.fill(cnt, 1); // 什么也不装也是一种方案

		for (int i = 1; i <= n; i++) {
			String[] cur = in.readLine().split(" ");
			int v = Integer.parseInt(cur[0]);
			int w = Integer.parseInt(cur[1]);
			for (int j = m; j >= v; j--) {
				int b = f[j - v] + w;
				if (b > f[j]) {
					f[j] = b;
					cnt[j] = cnt[j - v];
				}
				if (b == f[j])
					cnt[j] = (cnt[j] + cnt[j - v]) % MOD;
			}
		}
		System.out.println(cnt[m]);
	}
}
