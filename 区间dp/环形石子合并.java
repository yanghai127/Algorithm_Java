package 区间dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 环形石子合并 {
	// 存两遍就行了，f含义和石子合并一样
	static int N = 410, INF = 0x3f3f3f3f;
	static int[] w = new int[N], s = new int[N];
	static int[][] f = new int[N][N], g = new int[N][N];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] arr = in.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			w[i] = Integer.parseInt(arr[i - 1]);
			w[i + n] = w[i];
		}
		// 初始化前置数组
		for (int i = 1; i <= 2 * n; i++)
			s[i] = s[i - 1] + w[i];

		for (int i = 1; i <= 2 * n; i++) {
			Arrays.fill(f[i], INF);
			Arrays.fill(g[i], -INF);
		}

		for (int len = 1; len <= n; len++) {
			for (int l = 1; l + len - 1 <= 2 * n; l++) {
				int r = l + len - 1;
				if (len == 1)
					f[l][r] = g[l][r] = 0;
				else {
					for (int k = l; k < r; k++) {
						f[l][r] = Math.min(f[l][r], f[l][k] + f[k + 1][r] + s[r] - s[l - 1]);
						g[l][r] = Math.max(g[l][r], g[l][k] + g[k + 1][r] + s[r] - s[l - 1]);
					}
				}
			}
		}
		// 因为不知道缺口在哪，所以要遍历一遍
		int minv = INF, maxv = -INF;
		for (int i = 1; i <= n; i++) {
			minv = Math.min(minv, f[i][i + n - 1]);
			maxv = Math.max(maxv, g[i][i + n - 1]);
		}
		System.out.println(minv + "\n" + maxv);
	}
}
