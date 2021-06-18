package 暴力穷举算法;

import java.util.Scanner;

public class 等腰三角形 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		int x = 1, y = 0, z = 0;
		String[][] a = new String[n][2 * n - 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2 * n - 1; j++) {
				a[i][j] = ".";
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = n - i - 1; j == n - i - 1; j--) {
				if (x > 99) {
					if (z % 3 == 0) {
						a[i][j] = String.valueOf(x / 100);
					} else if (z % 3 == 1) {
						a[i][j] = String.valueOf(x % 100 / 10);
					} else {
						a[i][j] = String.valueOf(x % 100 % 10);
						x++;
					}
					z++;
				} else if (x > 9) {
					if (y % 2 == 0) {
						a[i][j] = String.valueOf(x / 10);
					} else {
						a[i][j] = String.valueOf(x % 10);
						x++;
					}
					y++;
				} else {
					a[i][j] = String.valueOf(x);
					x++;
				}
			}
		}
		for (int i = 1; i < 2 * n - 1; i++) {
			if (x > 99) {
				if (z % 3 == 0) {
					a[n - 1][i] = String.valueOf(x / 100);
				} else if (z % 3 == 1) {
					a[n - 1][i] = String.valueOf(x % 100 / 10);
				} else {
					a[n - 1][i] = String.valueOf(x % 100 % 10);
					x++;
				}
				z++;
			} else if (x > 9) {
				if (y % 2 == 0) {
					a[n - 1][i] = String.valueOf(x / 10);
				} else {
					a[n - 1][i] = String.valueOf(x % 10);
					x++;
				}
				y++;
			} else {
				a[n - 1][i] = String.valueOf(x);
				x++;
			}
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = n + i - 1; j < n * 2 - 1; j++) {
				if (j == n + i - 1) {
					if (x > 99) {
						if (z % 3 == 0) {
							a[i][j] = String.valueOf(x / 100);
						} else if (z % 3 == 1) {
							a[i][j] = String.valueOf(x % 100 / 10);
						} else {
							a[i][j] = String.valueOf(x % 100 % 10);
							x++;
						}
						z++;
					} else if (x > 9) {
						if (y % 2 == 0) {
							a[i][j] = String.valueOf(x / 10);
						} else {
							a[i][j] = String.valueOf(x % 10);
							x++;
						}
						y++;
					} else {
						a[i][j] = String.valueOf(x);
						x++;
					}
				} else {
					a[i][j] = "";
				}
			}
		}
		a[0][n - 1] = "1";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2 * n - 1; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}
