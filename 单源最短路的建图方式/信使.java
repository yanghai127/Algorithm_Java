package 单源最短路的建图方式;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 信使 {
	// floyd算法
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N = 105, INF = 0x3f3f3f3f;
	static int n, m;
	static int[][] dist = new int[N][N];

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}

		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		for (int i = 1; i <= m; i++) {
			arr = in.readLine().split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			int c = Integer.parseInt(arr[2]);
			dist[a][b] = dist[b][a] = Math.min(dist[a][b], c);
		}

		for (int k = 1; k <= n; k++)
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++)
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

		int res = -INF;
		for (int i = 2; i <= n; i++)
			if (res < dist[1][i])
				res = dist[1][i];

		System.out.println(res == INF ? -1 : res);
	}

	// spfa 做法
//	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//	static int N = 105, M = 405;
//	static int n, m, s, INF = 0x3f3f3f3f;
//	static int[] dist = new int[N];
//	static LinkedList<Integer> q = new LinkedList<>();
//	static boolean[] st = new boolean[N];
//	static int[] h = new int[N], e = new int[M], ne = new int[M], w = new int[M];
//	static int idx = 0;
//
//	public static void main(String[] args) throws IOException {
//		Arrays.fill(h, -1);
//		String[] arr = in.readLine().split(" ");
//		n = Integer.parseInt(arr[0]);
//		m = Integer.parseInt(arr[1]);
//		for (int i = 1; i <= m; i++) {
//			arr = in.readLine().split(" ");
//			int a = Integer.parseInt(arr[0]);
//			int b = Integer.parseInt(arr[1]);
//			int c = Integer.parseInt(arr[2]);
//			add(a, b, c);
//			add(b, a, c);
//		}
//		s = 1;
//		spfa();
//		int res = -INF;
//		for (int i = 1; i <= n; i++) {
//			if (res < dist[i]) {
//				res = dist[i];
//			}
//		}
//		System.out.println(res == INF ? -1 : res);
//	}
//
//	private static void spfa() {
//		Arrays.fill(dist, INF);
//		dist[1] = 0;
//		q.add(1);
//		st[1] = true;
//		while (!q.isEmpty()) {
//			int t = q.poll();
//			st[t] = false;
//			for (int i = h[t]; i != -1; i = ne[i]) {
//				int j = e[i];
//				if (dist[j] > dist[t] + w[i]) {
//					dist[j] = dist[t] + w[i];
//					if (!st[j]) {
//						q.add(j);
//						st[j] = true;
//					}
//				}
//			}
//		}
//
//	}
//
//	private static void add(int a, int b, int c) {
//		e[idx] = b;
//		w[idx] = c;
//		ne[idx] = h[a];
//		h[a] = idx++;
//	}
}
