package 背包模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 多重背包问题II {
	// 一维，不超过，最大值，多重背包二进制
	// 原理就是把一个种类的物品分组拆开，但仍然能组合出原来所有的种数，不能超
	static int N = 20002;
	static int[] v = new int[N], w = new int[N], f = new int[N];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		int p = 1;
		for (int i = 1; i <= n; i++) {
			arr = in.readLine().split(" ");
			int V = Integer.parseInt(arr[0]); // 体积
			int W = Integer.parseInt(arr[1]); // 价值
			int S = Integer.parseInt(arr[2]); // 数量
			for (int j = 1; j < S; p++) {
				v[p] = V * j;
				w[p] = W * j;
				S -= j;
				j *= 2;
			}
			if (S > 0) {
				v[p] = V * S;
				w[p] = W * S;
				p++;
			}
		}
		// p是真正的种类数，剩下的按普通01背包来算就行了，good
		for (int i = 1; i < p; i++)
			for (int j = m; j >= v[i]; j--)
				f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
		System.out.println(f[m]);
	}
}
