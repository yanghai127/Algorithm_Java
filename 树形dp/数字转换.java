package 树形dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 数字转换 {
	static int N = 50005, n;
	static int[] h = new int[N], e = new int[N], ne = new int[N];
	static int[] sum = new int[N];
	static boolean[] st = new boolean[N];
	static int idx, res;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Arrays.fill(h, -1);
		n = Integer.parseInt(in.readLine());
		// 初始化sum数组
		for (int i = 1; i <= n / 2; i++)
			for (int j = 2; j <= n / i; j++)
				sum[i * j] += i;

		for (int i = 1; i <= n; i++)
			if (i > sum[i]) {
				add(sum[i], i);
				st[i] = true;
			}

		for (int i = 1; i <= n; i++)
			if (st[i])
				dfs(i);
		System.out.println(res);
	}

	private static int dfs(int u) {
		st[u] = false;
		int d1 = 0, d2 = 0;
		for (int i = h[u]; i != -1; i = ne[i]) {
			int j = e[i];
			int d = dfs(j) + 1;

			if (d >= d1) {
				d2 = d1;
				d1 = d;
			} else if (d > d2) {
				d2 = d;
			}
		}
		// 因为这也是一棵拎起来的二叉树
		res = Math.max(res, d1 + d2);

		return d1;
	}

	private static void add(int a, int b) {
		e[idx] = b;
		ne[idx] = h[a];
		h[a] = idx++;
	}
}
