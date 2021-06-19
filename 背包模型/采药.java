package 背包模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 采药 {
	// 一维，不超过，最大值，01背包
	// 属性：count
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int m = 102, n = 1002, T, M;
	static int[] t = new int[m], v = new int[n], f = new int[n];

	public static void main(String[] args) throws IOException {
		String[] arr = in.readLine().split(" ");
		T = Integer.parseInt(arr[0]);
		M = Integer.parseInt(arr[1]);
		for (int i = 1; i <= M; i++) {
			arr = in.readLine().split(" ");
			t[i] = Integer.parseInt(arr[0]);
			v[i] = Integer.parseInt(arr[1]);
		}
		// 滚动数组优化，从后往前遍历
		for (int i = 1; i <= M; i++) // 遍历种类
			for (int j = T; j >= t[i]; j--) // 遍历体积
				f[j] = Math.max(f[j], f[j - t[i]] + v[i]);
		System.out.println(f[T]);
	}
}
