package 蓝桥杯真题;

import java.util.Scanner;

public class 图片旋转 {
	static int n, m;
	static int[][] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[m + 1][n + 1];
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++)
				a[j][n + 1 - i] = sc.nextInt();
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
