package 最长上升子序列模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 导弹防御系统 {
	// dfs+贪心，在拦截导弹那个题外面套一个暴搜
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int n, N = 52, ans;
	static int[] w = new int[N], up = new int[N], down = new int[N];

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(in.readLine());
		while (n != 0) {
			String[] arr = in.readLine().split(" ");
			for (int i = 1; i <= n; i++)
				w[i] = Integer.parseInt(arr[i - 1]);
			ans = n;
			dfs(1, 0, 0);
			System.out.println(ans);
			n = Integer.parseInt(in.readLine());
		}
	}

	// u代表当前遍历到的数，su代表上升子序列的个数，sd代表下降子序列的个数
	private static void dfs(int u, int su, int sd) {
		// 先设置下出口
		if (su + sd >= ans)
			return;
		if (u == n) {
			ans = su + sd;
			return;
		}

		// 情况1：将当前数放到上升子序列中
		int k = 0;
		while (k < su && w[u] <= up[k]) // 跟拦截导弹那个题原理是一样的
			k++;
		// 备份
		int t = up[k];
		up[k] = w[u];
		if (k < su)
			dfs(u + 1, su, sd);
		else
			dfs(u + 1, su + 1, sd);
		// 回溯
		up[k] = t;

		// 情况2，将当前数放到下降子序列中
		k = 0;
		while (k < sd && down[k] <= w[u])
			k++;
		t = down[k];
		down[k] = w[u];
		if (k < sd)
			dfs(u + 1, su, sd);
		else
			dfs(u + 1, su, sd + 1);
		down[k] = t;
	}
}
