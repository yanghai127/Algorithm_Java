package 最短路模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 武士风度的牛 {
	static class Node {
		int x;
		int y;
		int d;

		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static int N = 155, n, m, res;
	static char[][] w = new char[N][N];
	static Node[] q = new Node[N * N];
	static int[] dx = new int[] { 1, 1, -1, -1, 2, 2, -2, -2 };
	static int[] dy = new int[] { 2, -2, 2, -2, 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		m = Integer.parseInt(arr[1]); // 11
		n = Integer.parseInt(arr[0]); // 10
		for (int i = 1; i <= m; i++) {
			w[i] = (" " + in.readLine()).toCharArray();
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (w[i][j] == 'K') {
					res = bfs(i, j);
				}
			}
		}
		System.out.println(res);
	}

	private static int bfs(int i, int j) {
		int hh = 0, tt = -1;
		q[++tt] = new Node(i, j, 0);

		while (tt >= hh) {
			Node now = q[hh++];

			for (int k = 0; k < 8; k++) {
				int x = now.x + dx[k];
				int y = now.y + dy[k];
				if (x > m || x < 1 || y > n || y < 1 || w[x][y] == '*')
					continue;

				if (w[x][y] == 'H')
					return now.d + 1;

				w[x][y] = '*';
				q[++tt] = new Node(x, y, now.d + 1);
			}

		}
		return -1;
	}
}
