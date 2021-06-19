package 状态机模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 股票买卖V {
	static int N = 102, n, m;
	static int[] w = new int[100002];
	static int[][] f = new int[2][3];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		arr = in.readLine().split(" ");
		for (int i = 1; i <= n; i++)
			w[i] = Integer.parseInt(arr[i - 1]);
		f[0][1] = 0xcfcfcfcf;
		f[0][2] = 0xcfcfcfcf;
		for (int i = 1; i <= n; i++) {
			f[1][0] = Math.max(f[0][0], f[0][2]);
			f[1][1] = Math.max(f[0][1], f[0][0] - w[i]);
			f[1][2] = Math.max(f[0][2], f[0][1] + w[i]);
			System.arraycopy(f[1], 0, f[0], 0, 3);
		}
		System.out.println(Math.max(f[0][0], f[0][2]));
	}
}
