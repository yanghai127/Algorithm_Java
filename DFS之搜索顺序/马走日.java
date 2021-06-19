package DFS之搜索顺序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 马走日 {
	static int N = 10, n, m, cnt;
	static int sx, sy;
	static boolean[][] st;
	static int[] dx = new int[] { -1, -1, 2, 2, 1, 1, -2, -2 };
	static int[] dy = new int[] { 2, -2, -1, 1, -2, 2, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			cnt = 0;
			st = new boolean[N][N];
			String[] arr = in.readLine().split(" ");
			n = Integer.parseInt(arr[0]);
			m = Integer.parseInt(arr[1]);
			sx = Integer.parseInt(arr[2]);
			sy = Integer.parseInt(arr[3]);
			dfs(sx, sy, 1);
			System.out.println(cnt);
		}
	}

	private static void dfs(int x, int y, int s) {
		if (s == m * n) {
			cnt++;
			return;
		}
		st[x][y] = true;
		for (int k = 0; k < 8; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (nx >= n || ny >= m || nx < 0 || ny < 0 || st[nx][ny]) {
				continue;
			}
			dfs(nx, ny, s + 1);
		}
		st[x][y] = false;
	}

}
