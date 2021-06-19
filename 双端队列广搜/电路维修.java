package 双端队列广搜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

class Node {
	int i, j;

	public Node(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class 电路维修 {
	static int N = 505, n, m;
	static int[][] w = new int[N][N];
	static int[][] dist = new int[N][N];
	static boolean[][] st = new boolean[N][N];
	static String std = "\\/\\/";
	static int[] dx = { -1, -1, 1, 1 }, ix = { -1, -1, 0, 0 };
	static int[] dy = { -1, 1, 1, -1 }, iy = { -1, 0, 0, -1 };
	static LinkedList<Node> q = new LinkedList<Node>(); // 双向链表

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		while (T-- > 0) {
			String[] cur = in.readLine().split(" ");
			n = Integer.parseInt(cur[0]);
			m = Integer.parseInt(cur[1]);

			for (int i = 0; i < n; i++) {
				char[] arr = in.readLine().toCharArray();
				for (int j = 0; j < m; j++)
					w[i][j] = arr[j];
			}

			if ((n + m & 1) == 1)
				System.out.println("NO SOLUTION");
			else
				System.out.println(bfs());
		}
	}

	static int bfs() {
		q.clear();
		for (int i = 0; i <= n; i++) {
			Arrays.fill(st[i], false);
			Arrays.fill(dist[i], 0x3f3f3f3f);
		}

		q.add(new Node(0, 0));
		dist[0][0] = 0;

		while (!q.isEmpty()) {
			Node cur = q.removeFirst();
			int x = cur.i;
			int y = cur.j;

			if (st[x][y])
				continue;
			st[x][y] = true;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx > n || ny < 0 || ny > m)
					continue;
				// 获得当前这个方向可以走通时需要的原件的下标
				int sx = x + ix[i];
				int sy = y + iy[i];
				int v = w[sx][sy] == std.charAt(i) ? 0 : 1;
				if (dist[x][y] + v < dist[nx][ny]) {
					dist[nx][ny] = dist[x][y] + v;

					if (nx == n && ny == m)
						return dist[n][m];

					if (v == 0)
						q.addFirst(new Node(nx, ny));
					else
						q.addLast(new Node(nx, ny));
				}
			}
		}
		return -1;
	}
}
