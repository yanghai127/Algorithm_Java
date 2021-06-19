package 区间dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 能量项链 {
	// 矩阵乘法
	static int N = 210;
	static int[] w = new int[N];
	static int[][] f = new int[N][N];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
		String[] arr = in.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			w[i] = Integer.parseInt(arr[i - 1]);
			w[i + n] = w[i];
		}
		// 注意len <= n + 1，n个矩阵n + 1个数来存
		for (int len = 3; len <= n + 1; len++) {
			for (int l = 1; l + len - 1 <= 2 * n; l++) {
				int r = l + len - 1;
				for (int k = l + 1; k <= r - 1; k++)
					f[l][r] = Math.max(f[l][r], f[l][k] + f[k][r] + w[l] * w[r] * w[k]);
			}
		}

		int res = -1;
		for (int i = 1; i <= n; i++)
			res = Math.max(res, f[i][i + n]);

		System.out.println(res);
	}
}
