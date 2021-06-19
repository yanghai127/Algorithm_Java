package 背包模型;

import java.util.Scanner;

public class 机器分配 {
	// 一维，恰好为，最大值，分组背包
	// n代表公司总数，m代表机器总数
	static int N = 17, n, m;
	static int[] way = new int[N];
	static int[][] w = new int[N][N], f = new int[N][N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++)
				w[i][j] = sc.nextInt();

		for (int i = 1; i <= n; i++)
			for (int j = 0; j <= m; j++)
				for (int k = 0; k <= j; k++)
					f[i][j] = Math.max(f[i][j], f[i - 1][j - k] + w[i][k]);

		System.out.println(f[n][m]);
		// 从n再推回去
		for (int i = n, j = m; i > 0; i--)
			for (int k = 0; k <= j; k++) // 代表空余机器数量
				if (f[i][j] == f[i - 1][j - k] + w[i][k]) {
					way[i] = k;
					j -= k;
					break;
				}

		for (int i = 1; i <= n; i++)
			System.out.println(i + " " + way[i]);
		sc.close();
	}
}
