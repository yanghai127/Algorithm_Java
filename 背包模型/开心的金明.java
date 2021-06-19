package 背包模型;

import java.util.Scanner;

public class 开心的金明 {
	// 一维，不超过，最大值，01背包
	static int N = 30002, n;
	static int[] f = new int[N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 1; i <= m; i++) {
			int a = sc.nextInt(), b = sc.nextInt();
			for (int j = n; j >= a; j--)
				f[j] = Math.max(f[j], f[j - a] + a * b);
		}
		System.out.println(f[n]);
		sc.close();
	}
}
