package 树形dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 树的最长路径 {
	/* 	树形dp
	 * 	状态表示：f[u]
	 *	集合：f[u]代表u结点下的最长路径
	 *	属性：Max
	 *	状态计算：f[u]=max(f[u],dfs(s,u)+w[i])
	 *	初始化：f数组初始全为0即可
	 */
	static int N = 10010, M = 2 * N, n;
	static int[] e = new int[M], w = new int[M], ne = new int[M], h = new int[N];
	static int[] f = new int[N];
	static int res, idx;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Arrays.fill(h, -1);
		n = Integer.parseInt(in.readLine());
		for (int i = 1; i < n; i++) {
			String[] arr = in.readLine().split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			int c = Integer.parseInt(arr[2]);
			add(a, b, c);
			add(b, a, c);
		}
		dfs(1, -1); // 无向图随机代进去一个点就行
		System.out.println(res);
	}

	private static int dfs(int u, int father) {
		for (int i = h[u]; i != -1; i = ne[i]) {
			int s = e[i];
			if (s == father) // 无向树，但不能向上走
				continue;

			int d = dfs(s, u) + w[i];

			res = Math.max(res, d + f[u]); // 最长路径是最长距离+次长距离
			// f[u]存的是u这个结点下的最长路径
			f[u] = Math.max(f[u], d); // 更新f[u]
		}
		return f[u];
	}

	private static void add(int a, int b, int c) {
		e[idx] = b;
		w[idx] = c;
		ne[idx] = h[a];
		h[a] = idx++;
	}
}
