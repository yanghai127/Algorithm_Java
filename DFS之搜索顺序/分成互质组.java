package DFS之搜索顺序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 分成互质组 {

	static int N = 11;
	static int[] w = new int[N];
	@SuppressWarnings({ "rawtypes" })
	static ArrayList[] g = new ArrayList[N];
	static boolean[] st = new boolean[N];
	static int res = 10;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		String[] arr = in.readLine().split(" ");
		for (int i = 0; i < n; i++)
			w[i] = Integer.parseInt(arr[i]);

		for (int i = 0; i <= n; i++)
			g[i] = new ArrayList<Integer>();
		dfs(0, 0);
		System.out.println(res);
	}

	// u为当前枚举到第几个数，k为正在放第几组
	@SuppressWarnings("unchecked")
	private static void dfs(int u, int k) {
		if (u == n) {
			res = Math.min(res, k);
			return;
		}

		// 枚举第0组到第k - 1组看能否将u这个数放进前k - 1个集合
		for (int i = 0; i < k; i++) {
			if (check(g[i], w[u])) {
				g[i].add(w[u]);
				dfs(u + 1, k);
				g[i].remove(g[i].size() - 1);
			}
		}
		// 将u这个数单独放进一组中
		g[k].add(w[u]);
		dfs(u + 1, k + 1);
		g[k].remove(g[k].size() - 1);
	}

	private static boolean check(ArrayList<Integer> t, int x) {
		for (int i = 0; i < t.size(); i++) {
			if (gcd(x, t.get(i)) > 1)
				return false;
		}
		return true;
	}

	private static int gcd(int a, int b) {
		return b != 0 ? gcd(b, a % b) : a;
	}
}
