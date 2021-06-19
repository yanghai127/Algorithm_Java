package 区间dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 加分二叉树 {
	static int N = 35, n, INF = 0x3f3f3f3f;
	static int[] w = new int[N];
	static long[][] f = new long[N][N];
	static int[][] g = new int[N][N];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		String[] arr = in.readLine().split(" ");
		for (int i = 1; i <= n; i++)
			w[i] = Integer.parseInt(arr[i - 1]);

		for (int i = 1; i <= n; i++)
			Arrays.fill(f[i], -INF);

		for (int len = 1; len <= n; len++) {
			for (int l = 1; l + len - 1 <= n; l++) {
				int r = l + len - 1;

				if (len == 1) {
					f[l][r] = w[l];
					g[l][r] = l;
				} else {
					for (int k = l; k <= r; k++) {
						long left = k == l ? 1 : f[l][k - 1];
						long right = k == r ? 1 : f[k + 1][r];
						long val = left * right + w[k];
						if (val > f[l][r]) {
							f[l][r] = val;
							g[l][r] = k;
						}
					}
				}
			}
		}

		System.out.println(f[1][n]);
		dfs(1, n);
	}

	private static void dfs(int l, int r) {
		if (l > r)
			return;
		int k = g[l][r];
		System.out.print(k + " ");
		dfs(l, k - 1);
		dfs(k + 1, r);
	}
}
