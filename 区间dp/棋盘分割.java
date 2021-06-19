package 区间dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 棋盘分割 {
	static int N = 15, M = 9;
	static double INF = 1e9;
	static int n, m = 8;
	static int[][] w = new int[M][M];
	static double f[][][][][] = new double[N][N][N][N][N];
	static double X;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());

		for (int i = 1; i <= m; i++) {
			String[] arr = in.readLine().split(" ");
			for (int j = 1; j <= m; j++) {
				w[i][j] = Integer.parseInt(arr[j - 1]);
				w[i][j] += w[i - 1][j] + w[i][j - 1] - w[i - 1][j - 1];
			}
		}

		X = (double) w[m][m] / n;
		for (int i = 0; i < M; i++)
			for (int j = 0; j < M; j++)
				for (int k = 0; k < M; k++)
					for (int u = 0; u < M; u++)
						Arrays.fill(f[i][j][k][u], -1);

		System.out.printf("%.3f", Math.sqrt(dp(1, 1, 8, 8, n)));

	}

	private static double dp(int x1, int y1, int x2, int y2, int k) {
		if (f[x1][y1][x2][y2][k] >= 0)
			return f[x1][y1][x2][y2][k];
		if (k == 1)
			return f[x1][y1][x2][y2][k] = get(x1, y1, x2, y2);

		f[x1][y1][x2][y2][k] = INF;
		// 横着切
		for (int i = x1; i < x2; i++) {
			f[x1][y1][x2][y2][k] = Math.min(f[x1][y1][x2][y2][k], get(x1, y1, i, y2) + dp(i + 1, y1, x2, y2, k - 1));
			f[x1][y1][x2][y2][k] = Math.min(f[x1][y1][x2][y2][k], get(i + 1, y1, x2, y2) + dp(x1, y1, i, y2, k - 1));
		}
		// 纵着切
		for (int i = y1; i < y2; i++) {
			f[x1][y1][x2][y2][k] = Math.min(f[x1][y1][x2][y2][k], get(x1, y1, x2, i) + dp(x1, i + 1, x2, y2, k - 1));
			f[x1][y1][x2][y2][k] = Math.min(f[x1][y1][x2][y2][k], get(x1, i + 1, x2, y2) + dp(x1, y1, x2, i, k - 1));
		}

		return f[x1][y1][x2][y2][k];
	}

	private static double get(int x1, int y1, int x2, int y2) {
		double sum = w[x2][y2] - w[x2][y1 - 1] - w[x1 - 1][y2] + w[x1 - 1][y1 - 1] - X;
		return sum * sum / n;
	}
}
