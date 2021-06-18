package 随便写写;

import java.util.Scanner;

public class 最短路径 {
	/*
	 * 1 3 1 1 5 1 4 2 1
	 */
	static int[][] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = new int[4][4];
		for (int i = 1; i < 4; i++)
			for (int j = 1; j < 4; j++)
				a[i][j] = sc.nextInt();
		for (int i = 2; i < 4; i++) {
			a[i][1] += a[i - 1][1];
			a[1][i] += a[1][i - 1];
		}
		int minsum = f();
		System.out.println(minsum);
		sc.close();
	}

	private static int f() {
		for (int i = 2; i < 4; i++)
			for (int j = 2; j < 4; j++)
				a[i][j] += Math.min(a[i][j - 1], a[i - 1][j]);
		return a[3][3];
	}
}
