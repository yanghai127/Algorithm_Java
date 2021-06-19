package 双向DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 送礼物 {
	// 先算前一半(多算两层，后一半要排序)，再算后一半
	static int N = 50;
	static int[] w = new int[N];
	static int[] all = new int[1 << 25];
	static int n, m, k, cnt;
	static long res;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] cur = in.readLine().split(" ");
		m = Integer.parseInt(cur[0]);
		n = Integer.parseInt(cur[1]);

		for (int i = 0; i < n; i++)
			w[i] = Integer.parseInt(in.readLine());
		Arrays.sort(w, 0, n);
		reverse(w);

		k = n / 2 + 1;
		dfs1(0, 0);

		Arrays.sort(all, 0, cnt);
		cnt = unique();

		dfs2(k, 0);
		System.out.println(res);
	}

	static void reverse(int[] w) {
		for (int i = 0; i < n / 2; i++) {
			int tmp = w[i];
			w[i] = w[n - i - 1];
			w[n - i - 1] = tmp;
		}
	}

	// u代表当前物品下标，s代表物品组总重量
	static void dfs1(int u, int s) {
		if (u == k) {
			all[cnt++] = s;
			return;
		}
		// 不选
		dfs1(u + 1, s);
		// 选
		if ((long) s + w[u] <= m)
			dfs1(u + 1, s + w[u]);
	}

	static int unique() {
		int t = 0;
		for (int i = 0; i < cnt; i++) {
			if (i == 0 || all[i] != all[i - 1])
				all[t++] = all[i];
		}
		return t;
	}

	static void dfs2(int u, int s) {
		if (u == n) {
			int l = 0;
			int r = cnt - 1;
			while (l < r) {
				int mid = l + r + 1 >> 1;
				if (all[mid] > m - s)
					r = mid - 1;
				else
					l = mid;
			}
			res = Math.max(res, s + all[l]);
			return;
		}
		// 不选
		dfs2(u + 1, s);
		// 选
		if ((long) s + w[u] <= m)
			dfs2(u + 1, s + w[u]);
	}
}
