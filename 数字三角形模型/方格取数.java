package 数字三角形模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 方格取数 {
	// 两条线同时dp，f同时存两个点的状态
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N = 12;
	static int[][] w = new int[N][N];
	static int[][][] f = new int[N * 2][N][N];

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(in.readLine());
		int r = 1, c = 1, v = 1;
		while (!(r == 0 && c == 0 && v == 0)) {
			String[] arr = in.readLine().split(" ");
			r = Integer.parseInt(arr[0]);
			c = Integer.parseInt(arr[1]);
			v = Integer.parseInt(arr[2]);
			w[r][c] = v;
		}
		System.out.println(dp(n));
	}

	private static int dp(int n) {
		for (int k = 2; k <= 2 * n; k++) {
			for (int i1 = 1; i1 <= n && i1 < k; i1++) {
				for (int i2 = 1; i2 <= n && i2 < k; i2++) {
					int j1 = k - i1, j2 = k - i2;
					if (j1 <= n && j2 <= n) {
						int t = w[i1][j1];
						if (i1 != i2)
							t += w[i2][j2];
						f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1 - 1][i2 - 1] + t);
						f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1 - 1][i2] + t);
						f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1][i2 - 1] + t);
						f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1][i2] + t);
					}
				}
			}
		}
		return f[n * 2][n][n];
	}
}
