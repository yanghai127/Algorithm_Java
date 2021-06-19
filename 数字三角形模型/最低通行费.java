package 数字三角形模型;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 最低通行费 {
	static Scanner sc = new Scanner(System.in);
	static int N = 105, n;
	static int[][] f = new int[N][N];

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < N; i++) {
			Arrays.fill(f[i], 0x3f3f3f3f);
		}
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				f[i][j] = sc.nextInt();
			}
		}
		f[1][0] = 0;
		System.out.println(dp());
	}

	private static int dp() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				f[i][j] += Math.min(f[i][j - 1], f[i - 1][j]);
			}
		}
		return f[n][n];
	}
}
