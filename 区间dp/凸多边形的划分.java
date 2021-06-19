package 区间dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class 凸多边形的划分 {
	static int N = 55;
	static String INF = "10000000000000000000000000000000";
	static BigInteger[] w = new BigInteger[N];
	static BigInteger f[][] = new BigInteger[N][N];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		String[] arr = in.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			w[i] = new BigInteger(String.valueOf(arr[i - 1]));
			Arrays.fill(f[i], new BigInteger("0"));
		}

		for (int len = 3; len <= n; len++) {
			for (int l = 1; l + len - 1 <= n; l++) {
				int r = l + len - 1;
				f[l][r] = new BigInteger(INF);
				// f[i][j]代表从i到j区间中各种合并方案的最小值
				for (int k = l + 1; k < r; k++)
					f[l][r] = f[l][r].min(f[l][k].add(f[k][r]).add(w[l].multiply(w[r]).multiply(w[k])));
			}
		}

		System.out.println(f[1][n]);
	}
}
