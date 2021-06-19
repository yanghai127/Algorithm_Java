package 背包模型;

import java.util.Scanner;

public class 货币系统1 {
	// 一维，恰好为，方案数，完全背包
	static int N = 3002, n, m;
	static long[] f = new long[3002];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		f[0] = 1;
		for (int i = 1; i <= n; i++) {
			int w = sc.nextInt();
			for (int j = w; j <= m; j++)
				f[j] += f[j - w];
		}
		System.out.println(f[m]);
		sc.close();
	}
}
