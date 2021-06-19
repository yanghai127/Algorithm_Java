package 最短路模型;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 迷宫问题 {
	static class Node {
		int i;
		int j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int N = 1005, n, m;
	static int[][] w = new int[N][N];
	static Node[][] pre = new Node[N][N];
	static int[] q = new int[N * N];
	static int[] dx = new int[] { -1, 0, 1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(in.readLine());
		for (int i = 1; i <= n; i++) {
			String[] arr = in.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				w[i][j] = Integer.parseInt(arr[j - 1]);
			}
		}

		bfs(n, n);

		Node now = new Node(1, 1);
		while (true) {
			out.write((now.i - 1) + " " + (now.j - 1) + "\n");
			if (now.i == n && now.j == n)
				break;
			now = pre[now.i][now.j];
		}
		out.close();
	}

	private static void bfs(int i, int j) {
		w[i][j] = 1;
		int tt = -1, hh = 0;
		q[++tt] = i * 10000 + j;

		while (tt >= hh) {
			int nn = q[hh++];
			int nx = nn / 10000;
			int ny = nn % 10000;
			for (int k = 0; k < 4; k++) {
				int x = nx + dx[k];
				int y = ny + dy[k];
				if (x < 1 || x > n || y < 1 || y > n || w[x][y] == 1) {
					continue;
				}
				w[x][y] = 1;
				q[++tt] = x * 10000 + y;
				pre[x][y] = new Node(nx, ny);
			}
		}

	}
}
