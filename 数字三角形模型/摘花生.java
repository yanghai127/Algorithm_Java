package 数字三角形模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 摘花生 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N = 105, n, m;
	static int[][] f = new int[N][N];

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String[] arr = in.readLine().split(" ");
			n = Integer.parseInt(arr[0]);
			m = Integer.parseInt(arr[1]);
			for (int i = 1; i <= n; i++) {
				arr = in.readLine().split(" ");
				for (int j = 1; j <= m; j++) {
					f[i][j] = Integer.parseInt(arr[j - 1]);
				}
			}
			System.out.println(dp());
		}

	}

	private static int dp() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				f[i][j] += Math.max(f[i - 1][j], f[i][j - 1]);
			}
		}
		return f[n][m];
	}
}
