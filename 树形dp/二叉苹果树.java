package 树形dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 二叉苹果树 {
	// 有依赖的背包问题
	// f[u][j]
	static int N = 105, M = 2 * N, n, m;
	static int[][] f = new int[N][N];
	static int[] h = new int[N], e = new int[M], ne = new int[M], w = new int[M];
	static int idx;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Arrays.fill(h, -1);
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		for (int i = 1; i < n; i++) {
			arr = in.readLine().split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			int c = Integer.parseInt(arr[2]);
			add(a, b, c);
			add(b, a, c);
		}
		dfs(1, -1); // 根节点固定为1
		System.out.println(f[1][m]);
	}

	private static void dfs(int u, int father) {
		for (int i = h[u]; i != -1; i = ne[i]) {
			if (e[i] == father)
				continue;

			dfs(e[i], u);
			for (int j = m; j > 0; j--) // 枚举总树枝数量
				for (int k = 0; k + 1 <= j; k++) // 枚举一个子树中可能的树枝数量
					f[u][j] = Math.max(f[u][j], f[u][j - k - 1] + f[e[i]][k] + w[i]);
		}
	}

	private static void add(int a, int b, int c) {
		e[idx] = b;
		w[idx] = c;
		ne[idx] = h[a];
		h[a] = idx++;
	}
}
