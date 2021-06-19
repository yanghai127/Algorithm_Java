package 单源最短路的建图方式;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class 香甜的黄油 {
	// spfa做法，枚举起点，求总路线的最小值
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N = 805, M = 3000;
	static int cnt, n, m, INF = 0x3f3f3f3f;
	static int[] count = new int[N]; // 存每个牧场牛的数量
	static int[][] dist = new int[N][N];
	static LinkedList<Integer> q = new LinkedList<>();
	static boolean[][] st = new boolean[N][N];
	static int[] h = new int[N], e = new int[M], ne = new int[M], w = new int[M];
	static int idx = 0;

	public static void main(String[] args) throws IOException {
		Arrays.fill(h, -1);
		String[] arr = in.readLine().split(" ");
		cnt = Integer.parseInt(arr[0]);
		n = Integer.parseInt(arr[1]);
		m = Integer.parseInt(arr[2]);
		for (int i = 1; i <= cnt; i++) {
			int index = Integer.parseInt(in.readLine());
			count[index]++;
		}
		for (int i = 1; i <= m; i++) {
			arr = in.readLine().split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			int c = Integer.parseInt(arr[2]);
			add(a, b, c);
			add(b, a, c);
		}
		spfa();
		int res = INF;
		for (int i = 1; i <= n; i++) {
			if (h[i] == -1)
				continue;

			int sum = 0;
			for (int j = 1; j <= n; j++)
				sum += dist[i][j] * count[j];

			if (sum < res)
				res = sum;
		}
		System.out.println(res);
	}

	private static void spfa() {
		for (int s = 1; s <= n; s++) {
			q.clear();
			Arrays.fill(dist[s], INF); // 跟floyd初始化距离矩阵是一样的
			dist[s][s] = 0;
			q.add(s);
			st[s][s] = true;
			while (!q.isEmpty()) {
				int t = q.poll();
				st[s][t] = false;
				for (int i = h[t]; i != -1; i = ne[i]) {
					int j = e[i];
					if (dist[s][j] > dist[s][t] + w[i]) {
						dist[s][j] = dist[s][t] + w[i];
						if (!st[s][j]) {
							q.add(j);
							st[s][j] = true;
						}
					}
				}
			}
		}
	}

	private static void add(int a, int b, int c) {
		e[idx] = b;
		w[idx] = c;
		ne[idx] = h[a];
		h[a] = idx++;
	}
}
