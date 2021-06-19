package 最长上升子序列模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 合唱队形 {
	// 和登山是一道题
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N = 105, n;
	static int[] w = new int[N], f1 = new int[N], f2 = new int[N];

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(in.readLine());
		String[] arr = in.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			w[i] = Integer.parseInt(arr[i - 1]);
		}
		init();
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			ans = Math.max(f1[i] + f2[i] - 1, ans);
		}
		System.out.println(n - ans);
	}

	private static void init() {
		for (int i = 1; i <= n; i++) {
			f1[i] = 1;
			for (int j = i - 1; j > 0; j--)
				if (w[i] > w[j])
					f1[i] = Math.max(f1[i], f1[j] + 1);
		}
		for (int i = n; i > 0; i--) {
			f2[i] = 1;
			for (int j = i + 1; j <= n; j++)
				if (w[i] > w[j])
					f2[i] = Math.max(f2[i], f2[j] + 1);
		}
	}
}
