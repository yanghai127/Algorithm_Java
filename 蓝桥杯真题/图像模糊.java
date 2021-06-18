package 蓝桥杯真题;

import java.util.Scanner;

public class 图像模糊 {
	static int m, n;
	static int[][] a, b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n][m];
		b = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				b[i][j] = f(i, j);
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static int f(int r, int c) {
		int sum = 0, count = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (r + i >= 0 && r + i < n && j + c >= 0 && j + c < m) {
					sum += a[r + i][c + j];
					count++;
				}
			}
		}
		return sum / count;
	}
}
