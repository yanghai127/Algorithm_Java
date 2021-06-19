package 背包模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 多重背包问题III {
	// 二维，不超过，最大值，多重背包，单调队列
	// q代表队列
	static int N = 20002;
	static int f[] = new int[N], g[] = new int[N], q[] = new int[N];

	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		for (int i = 0; i < n; i++) {
			arr = in.readLine().split(" ");
			int v = Integer.parseInt(arr[0]);
			int w = Integer.parseInt(arr[1]);
			int s = Integer.parseInt(arr[2]);
			// 更新g，把前面数组内容复制到后面里去
			System.arraycopy(f, 0, g, 0, m + 1);

			for (int j = 0; j < v; j++) { // j代表余数
				// hh代表队头，tt代表队尾，队尾进队头出
				int hh = 0, tt = -1;
				for (int k = j; k <= m; k += v) {
					if (hh <= tt && q[hh] < k - s * v)
						hh++; // 队头出列
					if (hh <= tt) // 队不为空，更新最大值
						f[k] = Math.max(f[k], g[q[hh]] + (k - q[hh]) / v * w);
					while (hh <= tt && g[q[tt]] - (q[tt] - j) / v * w <= g[k] - (k - j) / v * w)
						tt--;
					q[++tt] = k;
				}
			}

		}
		System.out.println(f[m]);
	}

}
