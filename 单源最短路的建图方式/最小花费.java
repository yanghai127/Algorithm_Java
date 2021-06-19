package 单源最短路的建图方式;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 最小花费 {
	// dijkstara做法，找最大值
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N = 2010;
	static double[][] g = new double[N][N]; // 使用邻接矩阵存图
	static double[] dist = new double[N];
	static boolean[] st = new boolean[N];
	static int s, t, n, m;

	public static void main(String[] args) throws IOException {
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);

		while (m-- > 0) {
			String[] cur = in.readLine().split(" ");
			int a = Integer.parseInt(cur[0]);
			int b = Integer.parseInt(cur[1]);
			int c = Integer.parseInt(cur[2]);
			double z = (100 - c) * 0.01;
			g[a][b] = g[b][a] = Math.max(g[a][b], z); // 避免重边
		}

		String[] tmp = in.readLine().split(" ");
		s = Integer.parseInt(tmp[0]);
		t = Integer.parseInt(tmp[1]);

		Dijkstra();

		System.out.printf("%.8f", 100 / dist[t]);
	}

	static void Dijkstra() {
		// 现在要找最大值，且权值非负，所以不初始化dist和g
		dist[s] = 1;
		for (int i = 1; i < n; i++) {
			int t = -1;
			for (int j = 1; j <= n; j++) {
				if (!st[j] && (t == -1 || dist[t] < dist[j])) {
					t = j;
				}
			}
			st[t] = true;
			for (int j = 1; j <= n; j++) {
				dist[j] = Math.max(dist[j], dist[t] * g[t][j]);
			}
		}
	}
}
