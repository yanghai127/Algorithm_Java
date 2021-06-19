package 状态压缩dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 最短Hamilton路径 {
	// 状压dp之集合，属性：Min
	static int N = 20, M = 1 << N, n;
	static int[][] f = new int[M][N], w = new int[N][N];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		for (int i = 0; i < n; i++) {
			arr = in.readLine().split(" ");
			for (int j = 0; j < n; j++)
				w[i][j] = Integer.parseInt(arr[j]);
		}

		for (int[] x : f)
			Arrays.fill(x, 0x3f3f3f3f);
		f[1][0] = 0;
		// 状态转移大多是从后往前转移！已知当前状态，找可以从哪些状态转移过来
		// f[i][j]中i代表当前状态数，j代表当前位置，推的是当前状态可以从哪些状态转移过来
		for (int i = 0; i < 1 << n; i++) // 枚举所有状态
			for (int j = 0; j < n; j++) // 枚举可以去的点
				if ((i >> j & 1) == 1) // 判断能否到达j位置
					for (int k = 0; k < n; k++) // 枚举可走到j位置的当前位置
						if ((i - (1 << j) >> k & 1) == 1) // 代表可以从k转移状态
							f[i][j] = Math.min(f[i][j], f[i - (1 << j)][k] + w[k][j]);
		// 输出所有地点都走到的最短路径
		System.out.println(f[(1 << n) - 1][n - 1]);
	}
}
