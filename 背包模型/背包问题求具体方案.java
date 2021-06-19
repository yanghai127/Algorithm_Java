package 背包模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 背包问题求具体方案 {
	// 一维，不超过，最大值，01背包，求具体方案
	static int N = 1002, n, m;
	static int[] w = new int[N], v = new int[N];
	static int[][] f = new int[N][N];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] s = in.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		for (int i = 1; i <= n; i++) {
			s = in.readLine().split(" ");
			w[i] = Integer.parseInt(s[0]);
			v[i] = Integer.parseInt(s[1]);
		}
		
		for (int i = n; i > 0; i--) {
			for (int j = 1; j <= m; j++) {
				f[i][j] = f[i + 1][j];
				if (j >= w[i])
					f[i][j] = Math.max(f[i][j], f[i + 1][j - w[i]] + v[i]);
			}
		}
		// f[1][m]是最大值，跟分配机器那个题一样，倒着推回去
		for (int i = 1, j = m; i <= n; i++) {
			// 求字典序最小，所以j=w[i]时也要输出
			if (j >= w[i] && f[i][j] == f[i + 1][j - w[i]] + v[i]) {
				System.out.print(i + " ");
				j -= w[i];
			}
		}
	}
}
