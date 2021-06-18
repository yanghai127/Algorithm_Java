package 蓝桥杯真题;

import java.util.Scanner;

public class 矩阵计数 {
	static int n, m;
	static int[][] a = new int[7][7];
	static long ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a[1][1] = 2;
		dfs(1, 1);
		a[1][1] = 1;
		dfs(1, 1);
		System.out.println(ans);
		sc.close();
	}

	static void dfs(int i, int j) {
		if (i == n && j == m) {
			ans++;
			return;
		}
		if (j == m) {
			if (i > 1 && a[i][1] == 1 && a[i - 1][1] == 1) {
				a[i + 1][1] = 2;
				dfs(i + 1, 1);
				a[i + 1][1] = 0;
			} else {
				a[i + 1][1] = 2;
				dfs(i + 1, 1);
				a[i + 1][1] = 1;
				dfs(i + 1, 1);
				a[i + 1][1] = 0;
			}
		} else {
			a[i][j + 1] = 2;
			dfs(i, j + 1);
			a[i][j + 1] = 0;
			if (!((i > 2 && a[i - 1][j + 1] == 1 && a[i - 2][j + 1] != 1)
					|| (j > 1 && a[i][j] == 1 && a[i][j - 1] == 1))) {
				a[i][j + 1] = 1;
				dfs(i, j + 1);
				a[i][j + 1] = 0;
			}
		}
	}

}
