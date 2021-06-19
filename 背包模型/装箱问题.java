package 背包模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 装箱问题 {
	// 一维，不超过，最大值，01背包
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int n, N = 20002, w, v;
	static int[] f = new int[N];

	public static void main(String[] args) throws IOException {
		v = Integer.parseInt(in.readLine());
		n = Integer.parseInt(in.readLine());
		for (int i = 1; i <= n; i++) {
			w = Integer.parseInt(in.readLine());
			for (int j = v; j >= w; j--)
				f[j] = Math.max(f[j], f[j - w] + w);
		}
		System.out.println(v - f[v]);
	}
}
