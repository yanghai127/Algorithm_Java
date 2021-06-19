package 背包模型;

import java.util.Arrays;
import java.util.Scanner;

public class 潜水员 {
	// 二维，不少于，最小值，01背包
	static final int M = 22, N = 80, INF = 0x3f3f3f3f;
	static int[][] f = new int[M][N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int o = sc.nextInt(), n = sc.nextInt(), K = sc.nextInt();

		for (int[] arr : f)
			Arrays.fill(arr, INF);
		f[0][0] = 0;

		for (int i = 1; i <= K; i++) {
			int v1 = sc.nextInt(), v2 = sc.nextInt(), w = sc.nextInt();
			for (int j = o; j >= 0; j--)
				for (int k = n; k >= 0; k--) // 下面这行少于零直接按零来算
					f[j][k] = Math.min(f[j][k], f[Math.max(0, j - v1)][Math.max(0, k - v2)] + w);
		}

		System.out.println(f[o][n]);
		sc.close();
	}
}
