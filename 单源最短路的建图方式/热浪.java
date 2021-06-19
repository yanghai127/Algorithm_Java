package 单源最短路的建图方式;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class 热浪 {
	// spfa做法，有风险，时间复杂度最多O(n*m)
	static int N = 2510, M = 6200 * 2 + 10, INF = 0x3f3f3f3f;
	static int n, m, s, t;
	static int[] h = new int[N], e = new int[M], ne = new int[M], w = new int[M];
	// 链表(也可以手写队列)存点，邻接矩阵存边
	static int[] dist = new int[N];
	static LinkedList<Integer> q = new LinkedList<>();
	static boolean[] st = new boolean[N];
	static int idx = 0;

	static void add(int a, int b, int c) {
		e[idx] = b;
		w[idx] = c;
		ne[idx] = h[a];
		h[a] = idx++;
	}

	public static void main(String[] args) throws IOException {
		Arrays.fill(h, -1);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		s = Integer.parseInt(arr[2]);
		t = Integer.parseInt(arr[3]);
		for (int i = 1; i <= m; i++) {
			arr = in.readLine().split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			int c = Integer.parseInt(arr[2]);
			add(a, b, c);
			add(b, a, c);
		}
		spfa();
		System.out.println(dist[t]);
	}

	private static void spfa() {
		Arrays.fill(dist, INF);
		dist[s] = 0;
		q.add(s);
		st[s] = true; // 进入链表置成true
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
}
