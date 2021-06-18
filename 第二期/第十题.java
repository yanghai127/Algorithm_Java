package 第二期;

import java.util.Scanner;

public class 第十题 {
	static int n, m;
	static int[][] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				a[i][j] = sc.nextInt();
				a[i][j] += dfs(i, j);
			}
		}
		System.out.println(a[n][m]);
		sc.close();
	}

	private static int dfs(int r, int c) {
		int max = -0x3f3f3f3f;
		for (int i = -3; i <= 0; i++) {
			for (int j = -3; j <= 0; j++) {
				if (i + j < -3 || i + j == 0 || i + r < 1 || j + c < 1)
					continue;
				if (a[i + r][j + c] > max)
					max = a[i + r][j + c];
			}
		}
		return max == -0x3f3f3f3f ? 0 : max;
	}
}
