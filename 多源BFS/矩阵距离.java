package 多源BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 矩阵距离 {
	// 求非1结点到1的最短曼哈顿距离
	static final int MOD = 10000;
	static int N = 1005, n, m;
	static int[][] w = new int[N][N];
	static int[] q = new int[N * N];
	static int tt = -1, hh = 0;
	static boolean[][] st = new boolean[N][N];
	static int[] dx = new int[] { 1, 0, 0, -1 };
	static int[] dy = new int[] { 0, -1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		for (int i = 1; i <= n; i++) {
			arr = in.readLine().split("");
			for (int j = 1; j <= m; j++) {
				w[i][j] = Integer.parseInt(arr[j - 1]);
			}
		}

		bfs();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++)
				out.write(w[i][j] + " ");
			out.write("\n");
		}
		out.close();
	}

	private static void bfs() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (w[i][j] == 1) {
					st[i][j] = true;
					w[i][j] = 0;
					q[++tt] = i * MOD + j;
				}
			}
		}

		while (tt >= hh) {
			int nn = q[hh++];
			for (int k = 0; k < 4; k++) {
				int x = nn / MOD + dx[k];
				int y = nn % MOD + dy[k];
				if (x > n || y > m || x < 1 || y < 1 || st[x][y])
					continue;
				st[x][y] = true;
				w[x][y] = w[nn / MOD][nn % MOD] + 1;
				q[++tt] = x * MOD + y;
			}
		}

	}
}
