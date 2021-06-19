package 背包模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 没有上司的舞会 {
	// 分根节点来不来两种情况来讨论，类似状态机
	static int N = 6010, n;
	// 邻接表用来存树
	static int[] e = new int[N], ne = new int[N], h = new int[N], w = new int[N];
	static boolean[] st = new boolean[N];
	static int[][] f = new int[N][2];
	static int idx = 0;

	static void add(int a, int b) {
		e[idx] = b;
		ne[idx] = h[a];
		h[a] = idx++;
	}

	static void dfs(int u) {
		f[u][1] = w[u];
		for (int i = h[u]; i != -1; i = ne[i]) {
			int j = e[i];
			dfs(j);

			f[u][1] += f[j][0]; // 根结点选
			f[u][0] += Math.max(f[j][1], f[j][0]); // 根节点不选
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Arrays.fill(h, -1);
		n = Integer.parseInt(in.readLine());
		for (int i = 1; i <= n; i++)
			w[i] = Integer.parseInt(in.readLine());

		for (int i = 1; i <= n - 1; i++) {
			String[] arr = in.readLine().split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			add(b, a);
			st[a] = true;
		}

		int r = 1;
		while (st[r])
			r++;
		dfs(r);

		System.out.println(Math.max(f[r][0], f[r][1]));
	}
}
