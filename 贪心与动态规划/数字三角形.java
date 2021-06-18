package 贪心与动态规划;

import java.util.Scanner;

/*
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
*/
public class 数字三角形 {
	static int n;
	static int[][] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= i; j++)
				a[i][j] = sc.nextInt();
		int max = f();
		System.out.println(max);
		sc.close();
	}

	private static int f() {
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= i; j++)
				a[i][j] += Math.max(a[i - 1][j], a[i - 1][j - 1]);
		int max = 0;
		for (int i = 1; i <= n; i++)
			if (a[n][i] > max)
				max = a[n][i];
		return max;
	}
}
