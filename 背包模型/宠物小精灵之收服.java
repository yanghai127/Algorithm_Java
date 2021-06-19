package 背包模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 宠物小精灵之收服 {
	// 二维，不超过，最大值，01背包
	// k代表野生精灵数量，n代表精灵球数量，r代表皮卡丘剩余体力，r不能等于0
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int n = 1002, r = 502;
	static int[][] f = new int[n][r];

	public static void main(String[] args) throws IOException {
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		r = Integer.parseInt(arr[1]);
		int K = Integer.parseInt(arr[2]);

		for (int i = 1; i <= K; i++) {
			arr = in.readLine().split(" ");
			int v1 = Integer.parseInt(arr[0]);
			int v2 = Integer.parseInt(arr[1]);
			for (int j = n; j >= v1; j--)
				for (int k = r - 1; k >= v2; k--)
					f[j][k] = Math.max(f[j][k], f[j - v1][k - v2] + 1);
		}

		System.out.print(f[n][r - 1] + " ");
		int k = r - 1;
		while (k > 0 && f[n][k - 1] == f[n][r - 1])
			k--;
		System.out.println(r - k);
	}
}
