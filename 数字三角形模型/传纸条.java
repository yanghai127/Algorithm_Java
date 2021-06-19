package 数字三角形模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 传纸条 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N = 52;
	static int[][] w = new int[N][N];
	static int[][][] f = new int[N * 2][N][N];

	public static void main(String[] args) throws IOException {
		String[] arr = in.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		for (int i = 1; i <= n; i++) {
			arr = in.readLine().split(" ");
			for (int j = 1; j <= m; j++) {
				w[i][j] = Integer.parseInt(arr[j - 1]);
			}
		}

		for (int k = 2; k <= m + n; k++) {
			for (int i1 = 1; i1 <= n && i1 < k; i1++) {
				for (int i2 = 1; i2 <= n && i2 < k; i2++) {
					int j1 = k - i1, j2 = k - i2;
					if (j1 <= m && j2 <= m) {
						int t = w[i1][j1];
						if (i1 != i2)
							t += w[i2][j2];
						f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1][i2] + t);
						f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1 - 1][i2 - 1] + t);
						f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1 - 1][i2] + t);
						f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1][i2 - 1] + t);
					}
				}
			}
		}
		System.out.println(f[m + n][n][n]);
	}
}
