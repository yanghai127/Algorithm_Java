package DFS之连通性模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 迷宫 {
	static boolean ok = false;
	static int N = 105, n, ex, ey;
	static char[][] w = new char[N][N];
	static int[] dx = new int[] { -1, 0, 1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };
	static boolean[][] st;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			ok = false;
			st = new boolean[N][N];
			n = Integer.parseInt(in.readLine());
			for (int i = 0; i < n; i++) {
				w[i] = in.readLine().toCharArray();
			}
			String[] arr = in.readLine().split(" ");
			int sx = Integer.parseInt(arr[0]);
			int sy = Integer.parseInt(arr[1]);
			ex = Integer.parseInt(arr[2]);
			ey = Integer.parseInt(arr[3]);
			dfs(sx, sy);
			System.out.println(ok ? "YES" : "NO");
		}
	}

	private static void dfs(int sx, int sy) {
		if (w[sx][sy] == '#') {
			return;
		}
		if (sx == ex && sy == ey) {
			ok = true;
			return;
		}
		for (int k = 0; k < 4; k++) {
			int nx = sx + dx[k];
			int ny = sy + dy[k];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n || st[nx][ny] || w[nx][ny] == '#') {
				continue;
			}
			st[nx][ny] = true;
			dfs(nx, ny);
		}
	}
}
