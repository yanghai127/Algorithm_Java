package 背包模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 数字组合 {
	// 一维，恰好取，求方案数，01背包
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N = 102, n, M;
	static int[] f = new int[10002];

	public static void main(String[] args) throws IOException {
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		M = Integer.parseInt(arr[1]);
		f[0] = 1;
		
		arr = in.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			int w = Integer.parseInt(arr[i - 1]);
			for (int j = M; j >= w; j--)
				f[j] += f[j - w];
		}
		
		System.out.println(f[M]);
	}
}
