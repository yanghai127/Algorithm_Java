package 最长上升子序列模型;

import java.util.Scanner;

public class 最长上升子序列1 {
	// 时间复杂度O(n^2)
	static int N = 1005;
	static int[] f = new int[N], w = new int[N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++)
			w[i] = sc.nextInt();
		
		int res = 1;
		for (int i = 1; i <= n; i++) {
			f[i] = 1;
			for (int j = i - 1; j > 0; j--)
				if (w[i] > w[j])
					f[i] = Math.max(f[i], f[j] + 1);
			res = Math.max(res, f[i]);
		}
		System.out.println(res);
		sc.close();
	}
}
