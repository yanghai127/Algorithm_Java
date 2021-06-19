package 背包模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 多重背包问题I {
	// 一维，不超过，最大值，多重背包朴素
	static int N = 105, n, m;
	static int[] f = new int[N];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		for (int i = 1; i <= n; i++) { // 枚举不同物品
			arr = in.readLine().split(" ");
			int v = Integer.parseInt(arr[0]);
			int w = Integer.parseInt(arr[1]);
			int s = Integer.parseInt(arr[2]);
			for (int j = m; j >= v; j--) // 枚举体积
				for (int k = 1; k <= s && j - k * v >= 0; k++)
					f[j] = Math.max(f[j], f[j - k * v] + k * w);
		}
		System.out.println(f[m]);
	}
}
