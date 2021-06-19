package 第十一届JB;

public class B扩散 {
	static final int n = 2020;

	public static void main(String[] args) {
		int[][] w = { { 0, 0 }, { 2020, 11 }, { 11, 14 }, { 2000, 2000 } };
		boolean[][] st = new boolean[n << 2 | 1][n << 2 | 1];
		long res = 0;
		for (int k = 0, x, y; k < 4; k++) {
			x = w[k][0] + n;
			y = w[k][1] + n;
			for (int i = -n; i <= n; i++)
				for (int r = n - abs(i), j = -r; j <= r; j++) {
					if (st[x + i][y + j])
						continue;
					st[x + i][y + j] = true;
					res++;
				}
		}
		System.out.println(res);
	}

	static int abs(int n) {
		return n > 0 ? n : -n;
	}
}
