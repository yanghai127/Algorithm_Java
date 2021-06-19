package 背包模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 有依赖的背包问题 {
	// 一维，不超过，最大值，01背包有依赖
	// 这里f[i][j]表示根节点为i，总体积不超过j所能获得的最大价值，不能用滚动数组
	static int N = 102, n, m, idx;
	static int[][] f = new int[N][N];
	static int[] v = new int[N], w = new int[N]; // 用来存体积和价值
	static int[] h = new int[N], e = new int[N], ne = new int[N];

	static void add(int a, int b) {
		e[idx] = b;
		ne[idx] = h[a];
		h[a] = idx++;
	}

	// 从root递归就是从叶子结点开始算，最后处理root层（递归是栈）
	static void dfs(int u) { // u代表根节点
		for (int i = h[u]; i != -1; i = ne[i]) { // 枚举根结点下的边
			int s = e[i]; // 记录子树的根节点 ，s代表son
			dfs(s);
			// 因为我们要遍历子节点，所以根节点是默认选择的，体积上限为 m-v[u]
			for (int j = m - v[u]; j >= 0; j--) // 从右往左遍历
				for (int k = 1; k <= j; k++) // 去遍历子节点的组合
					f[u][j] = Math.max(f[u][j], f[u][j - k] + f[s][k]);
		}
		// 将物品u(叶子)加入
		for (int j = m; j >= v[u]; j--)
			f[u][j] = f[u][j - v[u]] + w[u];
		// 因为我们是从叶子结点开始往上做，所以如果背包容积不如当前物品的体积大
		// 那就不能选择当前结点及其子节点，因此赋值为零
		for (int j = 0; j < v[u]; j++)
			f[u][j] = 0;
	}

	public static void main(String[] args) throws IOException {
		Arrays.fill(h, -1);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		int root = -1;
		for (int i = 1; i <= n; i++) {
			String[] cur = in.readLine().split(" ");
			v[i] = Integer.parseInt(cur[0]);
			w[i] = Integer.parseInt(cur[1]);
			int p = Integer.parseInt(cur[2]);
			if (p == -1)
				root = i;
			else
				add(p, i);
		}
		dfs(root);
		System.out.println(f[root][m]);
	}
}
