package 树形dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 战略游戏 {
	// 和没有上司的舞会有点像

	static int N = 1510, n;
	static int[] e = new int[N], ne = new int[N], h = new int[N];
	static boolean[] st = new boolean[N];
	static int[][] f = new int[N][2];
	static int idx;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String str = in.readLine();
			if (str == null)
				return;
			n = Integer.parseInt(str);

			Arrays.fill(h, -1);
			Arrays.fill(st, false);
			idx = 0;

			for (int i = 0; i < n; i++) {
				String[] arr = in.readLine().split(":");
				int a = Integer.parseInt(arr[0]);
				String[] sons = arr[1].split(" ");
				for (int j = 1; j < sons.length; j++) {
					int b = Integer.parseInt(sons[j]);
					add(a, b);
					st[b] = true;
				}
			}
			// 结点下标从0开始
			int r = 0;
			while (st[r])
				r++;
			dfs(r);

			System.out.println(Math.min(f[r][0], f[r][1]));
		}
	}

	private static void dfs(int u) {
		f[u][0] = 0;
		f[u][1] = 1;
		for (int i = h[u]; i != -1; i = ne[i]) {
			int j = e[i];
			dfs(j);
			
			f[u][0] += f[j][1];
			f[u][1] += Math.min(f[j][0], f[j][1]);
		}
	}

	private static void add(int a, int b) {
		e[idx] = b;
		ne[idx] = h[a];
		h[a] = idx++;
	}
}
