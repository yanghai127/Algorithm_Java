package 树形dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 树的中心 {
	static int N = 10010, M = N * 2, INF = 0x3f3f3f3f;
	static int[] e = new int[M], ne = new int[M], w = new int[M], h = new int[N];
	static int idx, n;
	// d1是当前结点向下的最大值，d2是当前结点向下的次大值
	static int[] d1 = new int[N], d2 = new int[N], up = new int[N];
	static int[] p1 = new int[N]; // 记录每个节点向下走最长路径经过的是哪个子节点

	static void add(int a, int b, int c) {
		e[idx] = b;
		w[idx] = c;
		ne[idx] = h[a];
		h[a] = idx++;
	}

	// 找到每个结点向下走的最长距离和次长距离(用子结点信息更新父节点信息)
	static int dfs_down(int u, int father) {
//		权值不为负，不用初始化为INF
//		d1[u] = d2[u] = -INF;
		for (int i = h[u]; i != -1; i = ne[i]) {
			int j = e[i];
			if (j == father)
				continue;
			int d = dfs_down(j, u) + w[i];
			// 更新最长路径和次长路径，这个状态还有用，用数组存下来
			if (d >= d1[u]) {
				d2[u] = d1[u];
				d1[u] = d;
				p1[u] = j;
			} else if (d > d2[u]) {
				d2[u] = d;
			}
		}

//		if (d1[u] == -INF)
//			d1[u] = d2[u] = 0;

		return d1[u]; // 返回最长距离
	}

	// 找到每个结点向上走的最长距离(用父节点信息更新子节点信息)
	static void dfs_up(int u, int father) {
		for (int i = h[u]; i != -1; i = ne[i]) {
			int j = e[i];
			if (j == father)
				continue;
			// 更新子节点
			if (j == p1[u])
				up[j] = Math.max(up[u], d2[u]) + w[i];
			else
				up[j] = Math.max(up[u], d1[u]) + w[i];
			dfs_up(j, u);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Arrays.fill(h, -1);
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		for (int i = 1; i < n; i++) {
			arr = in.readLine().split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			int c = Integer.parseInt(arr[2]);
			add(a, b, c);
			add(b, a, c);
		}

		dfs_down(1, -1); // 向下搜索
		dfs_up(1, -1); // 向上搜索

		int res = INF;
		for (int i = 1; i <= n; i++) {
			res = Math.min(res, Math.max(up[i], d1[i]));
		}
		System.out.println(res);
	}

}
