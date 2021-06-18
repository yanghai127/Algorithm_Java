package 第三期;

import java.util.Scanner;

/*
3 4
3 0 1 1
1 0 1 1
1 1 -2 4
 */
public class 矩阵重量 {
	static int n, m;
	static int[][] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++)
				a[i][j] = sc.nextInt() + a[i][j - 1] + a[i - 1][j] - a[i - 1][j - 1];
		int minn = Integer.MAX_VALUE;
		int r = 0, c = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				int temp = Math.abs(2 * a[i][j] - a[n][m]);
				if (temp <= minn) {
					if (temp < minn) {
						minn = temp;
						r = i;
						c = j;
					} else if (i * j <= r * c) {
						if (i * j < r * c) {
							minn = temp;
							r = i;
							c = j;
						} else if (i < r) {
							minn = temp;
							r = i;
							c = j;
						}
					}
				}
			}
		}
		System.out.println(r + " " + c);
		sc.close();
	}
}
