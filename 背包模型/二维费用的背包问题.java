package 背包模型;

import java.util.Scanner;

public class 二维费用的背包问题 {
	// 二维，不超过，最大值，01背包
	static int N = 1002, n;
	static int[][] f = new int[102][102];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int v = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			for (int j = v; j >= a; j--)
				for (int k = m; k >= b; k--)
					f[j][k] = Math.max(f[j][k], f[j - a][k - b] + c);
		}
		System.out.println(f[v][m]);
		sc.close();
	}
}
