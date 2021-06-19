package 状态机模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 大盗阿福 {
	static int N = 100002, n, m;
	static int[] w = new int[N];
	static int[][] f = new int[N][2];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String arr[] = in.readLine().split(" ");
		int T = Integer.parseInt(arr[0]);
		while (T-- > 0) {
			n = Integer.parseInt(in.readLine());
			arr = in.readLine().split(" ");
			for (int i = 1; i <= n; i++)
				w[i] = Integer.parseInt(arr[i - 1]);
			
			for (int i = 1; i <= n; i++) {
				f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
				f[i][1] = f[i - 1][0] + w[i];
			}
			
			System.out.println(Math.max(f[n][0], f[n][1]));
		}
	}
}
