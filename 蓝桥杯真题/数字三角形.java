package 蓝桥杯真题;

import java.util.Scanner;

public class 数字三角形 {
	// 最终向左和向右的次数不能相差超过1，不是每时每刻
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] a = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= i; j++)
				a[i][j] = sc.nextInt();
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= i; j++)
				a[i][j] += Math.max(a[i - 1][j], a[i - 1][j - 1]);
		if (n % 2 != 0)
			System.out.println(a[n][n / 2 + 1]);
		else
			System.out.println(Math.max(a[n][n / 2 + 1], a[n][n / 2]));
		sc.close();
	}
}
