package 第十一届JB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class I补给 {
	// 只能求无环最短路，而且有可能是偶尔准确
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N = 22, n, m, INF = 0x3f3f3f3f;
	static Node[] g = new Node[N];
	static int[] h = new int[N], e = new int[N * N], ne = new int[N * N];
	static double[] w = new double[N * N];
	static double[] dist = new double[N];
	static int idx = 0;
	static double res = 0, ans = INF, count = 0;
	static LinkedList<Integer> q = new LinkedList<>();
	static boolean[] st = new boolean[N];

	public static void main(String[] args) throws IOException {
		Arrays.fill(h, -1);
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		for (int i = 1; i <= n; i++) {
			arr = in.readLine().split(" ");
			int x = Integer.parseInt(arr[0]);
			int y = Integer.parseInt(arr[1]);
			g[i] = new Node(x, y);
		}
		for (int i = 1; i <= n; i++) {
			Node n1 = g[i];
			int x1 = n1.x;
			int y1 = n1.y;
			for (int j = 1; j <= n; j++) {
				if (j == i) {
					continue;
				}
				Node n2 = g[j];
				int x2 = n2.x;
				int y2 = n2.y;
				double c = path(x1 - x2, y1 - y2);
				if (c <= m) {
					add(i, j, c);
					add(j, i, c);
				}
			}
		}

		spfa();
		Arrays.fill(st, false);
		st[1] = true;
		dfs(1, 1);
	}

	private static void spfa() {
		Arrays.fill(dist, INF);
		dist[1] = 0;
		q.add(1);
		st[1] = true;
		while (!q.isEmpty()) {
			int t = q.poll();
			st[t] = false;
			for (int i = h[t]; i != -1; i = ne[i]) {
				int j = e[i];
				if (dist[j] > dist[t] + w[i]) {
					dist[j] = dist[t] + w[i];
					if (!st[j]) {
						q.add(j);
						st[j] = true;
					}
				}
			}
		}
	}

	private static void dfs(int x, int cnt) {
		if (check()) {
			count++;
			if (count == 2 * n + 1) {
				System.out.printf("%.2f", ans);
				System.exit(0);
			}
			if (x != 1)
				ans = Math.min(ans, res + dist[x]);
			else
				ans = Math.min(ans, res);
			return;
		}

		for (int i = h[x]; i != -1; i = ne[i]) {
			int j = e[i];
			st[j] = true;
			res += w[i];
			dfs(j, cnt + 1);
			res -= w[i];
			st[j] = false;
		}
	}

	private static boolean check() {
		for (int i = 1; i <= n; i++)
			if (!st[i])
				return false;
		return true;
	}

	private static double path(int i, int j) {
		return Math.sqrt(i * i + j * j);
	}

	private static void add(int a, int b, double c) {
		e[idx] = b;
		w[idx] = c;
		ne[idx] = h[a];
		h[a] = idx++;
	}

}
