package Flood_Fill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 山峰和山谷 {
	static class Node {
		int i, j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int N = 1010, M = N * N;
	static int[][] w = new int[N][N];
	static boolean[][] st = new boolean[N][N];
	static Node[] q = new Node[M];
	static int[] dx = { -1, 0, 1, 0, -1, -1, 1, 1 };
	static int[] dy = { 0, -1, 0, 1, -1, 1, -1, 1 };
	static boolean hasH, hasL; // hasH用于判断某个连通块周围是否有比它高的，hasL相反
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());

		for (int i = 0; i < n; i++) {
			String[] cur = in.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				w[i][j] = Integer.parseInt(cur[j]);
			}
		}

		int peak = 0;
		int valley = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (st[i][j])
					continue;
				hasH = false;
				hasL = false;
				bfs(i, j);
				if (!hasL)
					valley++;
				if (!hasH)
					peak++;
			}
		}

		System.out.println(peak + " " + valley);
	}

	static void bfs(int i, int j) {
		Node cur = new Node(i, j);

		int hh = 0;
		int tt = -1;
		q[++tt] = cur;
		st[i][j] = true;

		while (hh <= tt) {
			Node now = q[hh++];

			for (int k = 0; k < 8; k++) {
				int x = now.i + dx[k];
				int y = now.j + dy[k];

				if (x < 0 || x >= n || y < 0 || y >= n)
					continue;
				if (w[x][y] != w[now.i][now.j]) {
					if (w[x][y] > w[now.i][now.j])
						hasH = true;
					else
						hasL = true;
				} else if (!st[x][y]) {
					st[x][y] = true;
					q[++tt] = new Node(x, y);
				}
			}
		}
	}
}
