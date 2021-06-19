package 树形dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 皇宫看守 {
	static int N = 1510, n, m, INF = 0x3f3f3f3f;
	static int[] h = new int[N], e = new int[N], ne = new int[N], w = new int[N];
	static int[][] f = new int[N][3];
	static boolean[] st = new boolean[N];
	static int idx;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Arrays.fill(h, -1);
		n = Integer.parseInt(in.readLine());
		for (int i = 1; i <= n; i++) {
			String[] arr = in.readLine().split(" ");
			int a = Integer.parseInt(arr[0]);
			int c = Integer.parseInt(arr[1]);
			m = Integer.parseInt(arr[2]);
			w[a] = c;
			for (int j = 1; j <= m; j++) {
				int b = Integer.parseInt(arr[j + 2]);
				add(a, b);
				st[b] = true;
			}
		}
		// 结点下标从1开始
		int r = 1;
		while (st[r])
			r++;

		dfs(r);

		System.out.println(Math.min(f[r][1], f[r][2]));
	}

	private static void dfs(int u) {
		f[u][2] = w[u];

		for (int i = h[u]; i != -1; i = ne[i]) {
			int j = e[i];
			dfs(j);
			// 0代表父节点已被选，1代表子节点已被选，2代表当前结点已被选
			f[u][0] += Math.min(f[j][1], f[j][2]);
			f[u][2] += Math.min(Math.min(f[j][0], f[j][1]), f[j][2]);
		}

		f[u][1] = INF;
		for (int i = h[u]; i != -1; i = ne[i]) {
			int j = e[i];
			// 用f[u][0]代表sum
			f[u][1] = Math.min(f[u][1], f[j][2] + f[u][0] - Math.min(f[j][1], f[j][2]));
		}
	}

	private static void add(int a, int b) {
		e[idx] = b;
		ne[idx] = h[a];
		h[a] = idx++;
	}
}
