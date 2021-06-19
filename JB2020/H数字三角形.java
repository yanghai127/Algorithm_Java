package JB2020;

import java.util.Scanner;

public class H数字三角形 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[][] = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				a[i][j] = sc.nextInt();
				a[i][j] += Math.max(a[i - 1][j - 1], a[i - 1][j]);
			}
		}
		System.out.println(n % 2 == 1 ? a[n][n / 2 + 1] : Math.max(a[n][n / 2], a[n][n / 2 + 1]));
		sc.close();
	}
}
