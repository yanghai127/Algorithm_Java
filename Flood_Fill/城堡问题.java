package Flood_Fill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 城堡问题 {
	static int N = 55, n, m, cnt, maxx;
	static int[][] w = new int[N][N];
	static int[] q = new int[N * N];
	static boolean[][] st = new boolean[N][N];
	// 左上角是(0,0)坐标，坐标顺序不能改变
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		m = Integer.parseInt(arr[0]);
		n = Integer.parseInt(arr[1]);

		for (int i = 1; i <= m; i++) {
			arr = in.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				w[i][j] = Integer.parseInt(arr[j - 1]);
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (st[i][j])
					continue;
				st[i][j] = true;
				maxx = Math.max(maxx, bfs(i, j));
				cnt++;
			}
		}

		System.out.println(cnt + "\n" + maxx);
	}

	static int bfs(int i, int j) {
		int hh = 0, tt = -1;
		q[++tt] = i * 100 + j;
		int cnt = 0;

		while (hh <= tt) {
			cnt++;
			int nn = q[hh++];
			int nx = nn / 100;
			int ny = nn % 100;

			for (int k = 0; k < 4; k++) {
				if ((w[nx][ny] >> k & 1) == 1)
					continue;
				int x = nx + dx[k];
				int y = ny + dy[k];
				if (x < 1 || x > m || y < 1 || y > n)
					continue;
				if (st[x][y])
					continue;
				st[x][y] = true;
				q[++tt] = x * 100 + y;
			}
		}
		return cnt;
	}
}
