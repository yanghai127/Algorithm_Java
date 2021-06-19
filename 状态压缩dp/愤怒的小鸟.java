package 状态压缩dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 愤怒的小鸟 {
	// 状压dp之集合，属性：Min
	static final int N = 18, M = 1 << 18, INF = 0x3f3f3f3f;
	static final double esp = 1e-8;
	// path存的是所有路线，f代表达到每种状态最少需要多少线
	static int[][] path = new int[N][N];
	static int[] f = new int[M];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		int T = Integer.parseInt(arr[0]);
		while (T-- > 0) {
			arr = in.readLine().split(" ");
			int n = Integer.parseInt(arr[0]);
			List<double[]> q = new ArrayList<>(); // 用一维来存太麻烦了
			for (int i = 1; i <= n; i++) {
				arr = in.readLine().split(" ");
				q.add(new double[] { Double.parseDouble(arr[0]), Double.parseDouble(arr[1]) });
			}

			for (int[] a : path)
				Arrays.fill(a, 0);
			for (int i = 0; i < n; i++) {
				path[i][i] = 1 << i; // 当集合中只有一个点时，特殊规定只覆盖自己
				for (int j = 0; j < n; j++) {
					// 枚举两点，求出所有不同的抛物线
					double x1 = q.get(i)[0], y1 = q.get(i)[1];
					double x2 = q.get(j)[0], y2 = q.get(j)[1];
					if (cmp(x1, x2) == 0)
						continue; // 当 x1 = x2 时两点连线是一条 x 轴的垂线
					double a = (y1 / x1 - y2 / x2) / (x1 - x2);
					double b = y1 / x1 - a * x1;
					if (cmp(a, 0) >= 0)
						continue;

					for (int k = 0; k < n; k++) {
						// 求出当前抛物线经过哪些点
						double x = q.get(k)[0], y = q.get(k)[1];
						if (cmp(a * x * x + b * x, y) == 0)
							path[i][j] += 1 << k; // 二进制表示经过哪些点
					}
				}
			}

			Arrays.fill(f, INF);
			f[0] = 0;
			// 枚举所有状态
			for (int i = 0; i + 1 < 1 << n; i++) { // i + 1 < 1 << n 当包含所有点的时候就不需要更新了
				int x = 0;
				// 找一个状态i不经过的点
				for (int j = 0; j < n; j++) {
					if ((i >> j & 1) == 0) {
						x = j;
						break;
					}
				}
				// path代表由i，j两点所确定的抛物线的状态数（是否包含其它点）
				for (int j = 0; j < n; j++)
					f[i | path[x][j]] = Math.min(f[i | path[x][j]], f[i] + 1);
			}
			System.out.println(f[(1 << n) - 1]);
		}
	}

	static int cmp(double a, double b) {
		if (Math.abs(a - b) < esp)
			return 0;
		else if (a - b < 0)
			return -1;
		return 1;
	}
}
