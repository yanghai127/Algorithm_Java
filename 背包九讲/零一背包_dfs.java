package 背包九讲;

import java.util.Scanner;

public class 零一背包_dfs {
	static int n, t;
	static int[] v, w;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		n = sc.nextInt();
		v = new int[n + 1];
		w = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		int tt = t;
		int sum = dfs(1, tt);
		System.out.println(sum);
		sc.close();
	}

	private static int dfs(int i, int tt) {
		if (tt <= 0)
			return 0;
		if (i == n+1)
			return 0;
		int v2 = dfs(i + 1, tt);
		if (tt >= w[i]) {
			int v1 = v[i] + dfs(i + 1, tt - w[i]);
			return Math.max(v1, v2);
		} else
			return v2;
	}
}
