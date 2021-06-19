package 状态机模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 股票买卖IV {
	// 状态机，
	static int N = 102, n, m;
	static int[] w = new int[100002];
	static int[][] f = new int[N][2];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String arr[] = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		arr = in.readLine().split(" ");
		for (int i = 1; i <= n; i++)
			w[i] = Integer.parseInt(arr[i - 1]);

		for (int i = 0; i <= m; i++)
			f[i][1] = 0xcfcfcfcf; // 代表一开始不能从f[i][1]转移过去

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				f[j][0] = Math.max(f[j][0], f[j][1] + w[i]);
				f[j][1] = Math.max(f[j][1], f[j - 1][0] - w[i]);
			}
		}

		int res = 0;
		for (int i = 0; i <= m; i++)
			res = Math.max(res, f[i][0]);

		System.out.println(res);
	}
}
