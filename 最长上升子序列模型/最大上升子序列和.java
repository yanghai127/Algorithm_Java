package 最长上升子序列模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 最大上升子序列和 {
	// dp，属性：MAX
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int n, N = 1005;
	static int[] w = new int[N], f = new int[N];

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(in.readLine());
		String[] arr = in.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			w[i] = Integer.parseInt(arr[i - 1]);
		}
		int ans = init();
		System.out.println(ans);
	}

	private static int init() {
		int max = 0;
		for (int i = 1; i <= n; i++) {
			f[i] = w[i];
			for (int j = i - 1; j > 0; j--)
				if (w[i] > w[j])
					f[i] = Math.max(f[i], f[j] + w[i]);
			max = Math.max(f[i], max);
		}
		return max;
	}
}
