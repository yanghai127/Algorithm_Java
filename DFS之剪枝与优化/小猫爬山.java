package DFS之剪枝与优化;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 小猫爬山 {
	static int N = 20, n, m, res = 22;
	static int[] w = new int[N];
	static int[] g = new int[N];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);

		for (int i = 1; i <= n; i++) {
			w[i] = Integer.parseInt(in.readLine());
		}

		Arrays.sort(w, 1, n + 1);
		reverse();

		dfs(1, 1);
		System.out.println(res - 1);
	}
	// k代表组数，u代表当前物品下标
	private static void dfs(int u, int k) {
		if (k >= res) {
			return;
		}
		if (u == n + 1) {
			res = Math.min(res, k);
			return;
		}

		for (int i = 1; i < k; i++) {
			if (w[u] + g[i] <= m) {
				g[i] += w[u];
				dfs(u + 1, k);
				g[i] -= w[u];
			}
		}

		g[k] += w[u];
		dfs(u + 1, k + 1);
		g[k] -= w[u];
	}

	private static void reverse() {
		for (int i = 1; i < n / 2; i++) {
			int test = w[i];
			w[i] = w[n + 1 - i];
			w[n + 1 - i] = test;
		}
	}
}
