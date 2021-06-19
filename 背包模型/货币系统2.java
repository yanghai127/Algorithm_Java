package 背包模型;

import java.util.Arrays;
import java.util.Scanner;

public class 货币系统2 {
	// 一维，恰好为，存在方案，完全背包
	// 重在思维，从小往大推，大的可能被小的筛去
	static final int N = 102, M = 25002;
	static int[] w = new int[N];
	static boolean[] f = new boolean[M];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			for (int i = 1; i <= n; i++)
				w[i] = sc.nextInt();
			// 左闭右开区间
			Arrays.sort(w, 1, n + 1);
			int m = w[n];

			Arrays.fill(f, false);
			f[0] = true;

			int res = 0;
			for (int i = 1; i <= n; i++) {
				if (!f[w[i]])
					res++;
				for (int j = w[i]; j <= m; j++)
					f[j] |= f[j - w[i]];
			}
			System.out.println(res);
		}
		sc.close();
	}
}