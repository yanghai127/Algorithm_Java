package 背包模型;

import java.util.Scanner;

public class 庆功会 {
	// 一维，不超过，最大值，多重背包
	static int N = 6005, n, m;
	static int[] f = new int[N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			for (int j = m; j >= a; j--)
				// 多重背包，遍历所有能取的数量
				for (int k = 1; k <= c && k * a <= j; k++)
					f[j] = Math.max(f[j], f[j - k * a] + k * b);
		}
		System.out.println(f[m]);
		sc.close();
	}
}
