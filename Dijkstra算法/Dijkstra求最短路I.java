package Dijkstra算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Dijkstra求最短路I {
	// 时间复杂度O(n^2)，要求边权非负
	static int N = 505, n, m;
	static int[][] g = new int[N][N];
	static int[] dist = new int[N];
	static boolean[] st = new boolean[N];
	static int INF = 0x3f3f3f3f;
	// 求1号点到n号点的最短路，如果不存在则返回-1

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		for (int i = 1; i <= n; i++)
			Arrays.fill(g[i], INF);

		while (m-- > 0) {
			arr = in.readLine().split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			int c = Integer.parseInt(arr[2]);
			g[a][b] = Math.min(g[a][b], c);// 若有重边，选择最短的
		}
		System.out.println(dijkstra());
	}

	public static int dijkstra() {
		Arrays.fill(dist, INF);
		dist[1] = 0;
		for (int i = 1; i <= n; i++) {
			// 1、找到当前未标记过且离源点最近的点
			int t = -1;
			for (int j = 1; j <= n; j++) {
				if (!st[j] && (t == -1 || dist[t] > dist[j]))
					t = j;
			}
			// 2、标记该点已经确定最短距离
			st[t] = true;
			// 3、用该点更新其他点的距离
			for (int j = 1; j <= n; j++) {
				dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
			}
		}
		return dist[n] == INF ? -1 : dist[n];
	}
}
