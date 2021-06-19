package DFS之连通性模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 红与黑 {
	static int N = 25;
	static char[][] g = new char[N][N];
	static boolean[][] st = new boolean[N][N];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[1]);
		m = Integer.parseInt(arr[0]);

		while (n != 0 || m != 0) {
			int sx = 0;
			int sy = 0;
			for (int i = 0; i < n; i++) {
				Arrays.fill(st[i], false);
				char[] cur = in.readLine().toCharArray();
				for (int j = 0; j < m; j++) {
					if (cur[j] == '@') {
						sx = i;
						sy = j;
					}
					g[i][j] = cur[j];
				}
			}

			st[sx][sy] = true;
			System.out.println(dfs(sx, sy));

			arr = in.readLine().split(" ");
			n = Integer.parseInt(arr[1]);
			m = Integer.parseInt(arr[0]);
		}
	}

	static int dfs(int sx, int sy) {
		int cnt = 1;

		for (int i = 0; i < 4; i++) {
			int nx = sx + dx[i];
			int ny = sy + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;
			if (st[nx][ny] || g[nx][ny] == '#')
				continue;
			st[nx][ny] = true;

			cnt += dfs(nx, ny);
		}

		return cnt;
	}
}
