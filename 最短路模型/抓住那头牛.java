package 最短路模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 抓住那头牛 {
	static class Node {
		int x;
		int d;

		public Node(int x, int d) {
			this.x = x;
			this.d = d;
		}
	}

	static int n, k, res;
	static Node[] q = new Node[100010];
	static boolean[] st = new boolean[100010];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		k = Integer.parseInt(arr[1]);
		res = bfs(n);
		System.out.println(res);
	}

	private static int bfs(int n) {
		int hh = 0, tt = -1;
		q[++tt] = new Node(n, 0);
		st[n] = true;

		while (tt >= hh) {
			Node now = q[hh++];
			int idx = now.x;
			int d = now.d;

			if (idx == k) {
				return d;
			}

			if (idx * 2 < 100010 && !st[idx * 2]) {
				st[idx * 2] = true;
				q[++tt] = new Node(idx * 2, d + 1);
			}

			if ((idx - 1) >= 0 && !st[idx - 1]) {
				st[idx - 1] = true;
				q[++tt] = new Node(idx - 1, d + 1);
			}

			if ((idx + 1) <= k && !st[idx + 1]) {
				st[idx + 1] = true;
				q[++tt] = new Node(idx + 1, d + 1);
			}
		}
		return -1;
	}
}
