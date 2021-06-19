package 基础要打牢;

import java.util.Scanner;

/*
8
2 3 13
2 6 6
3 5 7
4 4 14
5 2 21
5 6 4
6 3 15
7 2 14
0 0 0

67
 */
public class 方格取数 {
	// 多线程dp
	static final int N = 15;
	static int n;
	static int w[][] = new int[N][N];
	static int f[][][] = new int[N * 2][N][N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (true) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int value = sc.nextInt();
			if (i == 0 && j == 0 && value == 0) {
				break;
			}
			w[i][j] = value;
		}
		/*
		 * k代表横纵坐标之和，用来简化数组大小
		 */
		for (int k = 2; k <= n + n; k++) {
			for (int i1 = 1; i1 <= n; i1++) {
				for (int i2 = 1; i2 <= n; i2++) {
					int j1 = k - i1, j2 = k - i2;
					if (j1 >= 1 && j1 <= n && j2 >= 1 && j2 <= n) {
						int t = w[i1][j1];
						if (i1 != i2)
							t += w[i2][j2];
						f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1 - 1][i2 - 1] + t);
						f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1 - 1][i2] + t);
						f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1][i2 - 1] + t);
						f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1][i2] + t);
					}
				}
			}
		}
		System.out.println(f[n + n][n][n]);
		// 比赛的时候这个可以不用加
		sc.close();
	}
}
