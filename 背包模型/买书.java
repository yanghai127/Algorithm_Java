package 背包模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 买书 {
	// 一维，恰好为，方案数，完全背包
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N = 1002, n;
	static int[] f = new int[N], w = new int[] { 10, 20, 50, 100 };

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(in.readLine());
		f[0] = 1;
		for (int i = 0; i < w.length; i++)
			for (int j = w[i]; j <= n; j++) // 只有完全背包从小到大循环
				f[j] += f[j - w[i]];
		System.out.println(f[n]);
	}
}
