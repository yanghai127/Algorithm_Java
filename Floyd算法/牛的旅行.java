package Floyd算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
	int x, y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class 牛的旅行 {
	// 找到距离最远的最短距离
	static int N = 155;
	static Node[] a = new Node[N];
	static double[][] d = new double[N][N];
	static double[] maxd = new double[N]; // 存储每一个点到与它在一个连通块中的点的最远距离
	static char[][] g = new char[N][N];
	static double INF = 1e20;

	static double get_dist(Node a, Node b) {
		double dx = a.x - b.x;
		double dy = a.y - b.y;

		return Math.sqrt(dx * dx + dy * dy);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			String[] cur = in.readLine().split(" ");
			int x = Integer.parseInt(cur[0]);
			int y = Integer.parseInt(cur[1]);
			// 数组a用来储存所有点之间的距离
			a[i] = new Node(x, y);
		}

		for (int i = 0; i < n; i++) {
			char[] cur = in.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				// 用于储存邻接矩阵
				g[i][j] = cur[j];
			}
		}
		// 初始化最短路径矩阵
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					if (g[i][j] == '1')
						d[i][j] = get_dist(a[i], a[j]);
					else
						d[i][j] = INF;
				}
			}
		}
		// floyd求最短路径
		for (int k = 0; k < n; k++)
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);

		// 计算连通点之间的最短路径
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (d[i][j] < INF) {
					maxd[i] = Math.max(maxd[i], d[i][j]);
				}
			}
		}
		// 不排除连通块内部距离才是最长的
		double res1 = 0;
		for (int i = 0; i < n; i++)
			res1 = Math.max(res1, maxd[i]);

		double res2 = INF;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 筛选出不连通的点尝试加边
				if (d[i][j] >= INF) {
					res2 = Math.min(res2, maxd[i] + maxd[j] + get_dist(a[i], a[j]));
				}
			}
		}

		System.out.printf("%.6f", Math.max(res1, res2));
	}
}
