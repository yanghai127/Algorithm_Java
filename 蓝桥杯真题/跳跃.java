package 蓝桥杯真题;

import java.util.Scanner;

public class 跳跃 {
	static int m, n, ans;
	static int[][] a;
	static int[] x, y;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		x = new int[] { 0, 0, 0, -1, -2, -3 };
		y = new int[] { -3, -2, -1, 0, 0, 0 };
		ans = dfs();
		System.out.println(ans);
		sc.close();
	}

	private static int dfs() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				int max = Integer.MIN_VALUE;
				for (int k = 0; k < 6; k++) {
					if (i + x[k] > 0 && j + y[k] > 0) {
						max = Math.max(max, a[i + x[k]][j + y[k]]);
					}
				}
				if (max != Integer.MIN_VALUE) {
					a[i][j] += max;
				}
			}
		}
		return a[n][m];
	}
}
