package 第十一届JB;

public class E玩具蛇 {
	// 不能一味的追求代码的简洁而忽视可读性
	static int N = 5, res;
	static boolean[][] st = new boolean[5][5];
	static int[] dx = new int[] { 1, 0, -1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };
	static int count = 0;

	public static void main(String[] args) {
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				count = 1;
				st[i][j] = true;
				dfs(i, j);
				st[i][j] = false;
			}
		}
		System.out.println(res);
	}

	private static void dfs(int x, int y) {
		if (count == 16)
			res++;
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (nx < 1 || nx > 4 || ny < 1 || ny > 4 || st[nx][ny])
				continue;
			st[nx][ny] = true;
			count++;
			dfs(nx, ny);
			count--;
			st[nx][ny] = false;
		}
	}
}
