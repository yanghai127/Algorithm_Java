package 蓝桥杯真题;

import java.util.Scanner;

public class 扫雷 {
	static int n, m;
	static int[][] a, b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n + 2][m + 2];
		b = new int[n + 2][m + 2];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				b[i][j] = f(i, j);
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static int f(int r, int c) {
		if (a[r][c] == 1) {
			return 9;
		}
		int count = 0;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (a[i + r][j + c] == 1) {
					count++;
				}
			}
		}
		return count;
	}
}
