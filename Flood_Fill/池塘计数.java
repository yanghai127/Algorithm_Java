package Flood_Fill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
	int i, j;

	public Node(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class 池塘计数 {
	static int N = 1005, n, m, res;
	static char[][] w = new char[N][N];
	static Node[] q = new Node[N * N];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] cur = in.readLine().split(" ");
		n = Integer.parseInt(cur[0]);
		m = Integer.parseInt(cur[1]);

		for (int i = 1; i <= n; i++) {
			char[] arr = in.readLine().toCharArray();
			for (int j = 1; j <= m; j++) {
				w[i][j] = arr[j - 1];
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (w[i][j] == 'W') {
					w[i][j] = '.';
					bfs(i, j);
					res++;
				}
			}
		}

		System.out.println(res);
	}

	static void bfs(int i, int j) {
		Node cur = new Node(i, j);
		int hh = 0;
		int tt = -1;
		q[++tt] = cur;

		while (hh <= tt) {
			Node now = q[hh++];
			for (int r = -1; r <= 1; r++) {
				for (int c = -1; c <= 1; c++) {
					if (r == 0 && c == 0)
						continue;

					int x = now.i + r;
					int y = now.j + c;
					if (x < 1 || x > n || y < 1 || y > m)
						continue;

					if (w[x][y] == 'W') {
						w[x][y] = '.';
						q[++tt] = new Node(x, y);
					}
				}
			}
			
		}
		
	}
}
