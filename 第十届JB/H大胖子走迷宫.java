package 第十届JB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class H大胖子走迷宫 {
	// 比普通bfs复杂一点而已，just so so
	static class Node {
		int x;
		int y;
		int t;

		public Node(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N = 305, n, m;
	static char[][] w = new char[N][N];
	static int[] r = new int[] { 2, 1, 0 };
	static boolean[][] st = new boolean[N][N];
	static LinkedList<Node> q = new LinkedList<Node>();
	static int[] dx = new int[] { 1, 0, -1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		for (int i = 0; i < n; i++)
			w[i] = in.readLine().toCharArray();
		
		q.add(new Node(2, 2, 0));
		st[2][2] = true;
		
		bfs();
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			Node now = q.poll();
			int x = now.x;
			int y = now.y;
			int t = now.t;

			if (x == n - 3 && y == n - 3) { // 出口
				System.out.println(t);
				return;
			}

			if (t / m < 2) // 待在原地，时刻加 1
				q.add(new Node(x, y, t + 1));
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nr = (t / m) > 2 ? 0 : r[t / m]; // 防止下标越界

				if (nx - nr < 0 || nx + nr >= n || ny - nr < 0 || ny + nr >= n || st[nx][ny])
					continue;

				boolean ok = true; // 是否能走到
				for (int j = nx - nr; j <= nx + nr; j++) {
					for (int m = ny - nr; m <= ny + nr; m++) {
						if (w[j][m] == '*') {
							ok = false;
							break;
						}
					}
				}

				if (ok) {
					st[nx][ny] = true;
					q.add(new Node(nx, ny, t + 1));
				}
			}
		}
	}
}