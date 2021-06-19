package 最长上升子序列模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.max;

public class 最长公共上升子序列 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static final int N = 3010;
	static int n;
	static int[] a = new int[N], b = new int[N], f = new int[N];

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(in.readLine());
		String[] arr = in.readLine().split(" ");
		for (int i = 1; i <= n; i++)
			a[i] = Integer.parseInt(arr[i - 1]);
		arr = in.readLine().split(" ");
		for (int i = 1; i <= n; i++)
			b[i] = Integer.parseInt(arr[i - 1]);

		for (int i = 1; i <= n; i++) {
			int maxv = 1;
			for (int j = 1; j <= n; j++) {
				if (a[i] == b[j])
					f[j] = max(f[j], maxv);
				if (b[j] < a[i])
					maxv = max(maxv, f[j] + 1);
			}
		}
		// 找最后一行中的最大值
		int res = 0;
		for (int i = 1; i <= n; i++)
			res = max(res, f[i]);
		System.out.println(res);
	}
}
