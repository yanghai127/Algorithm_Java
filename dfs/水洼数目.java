package dfs;

import java.util.Scanner;

public class 水洼数目 {
	static Scanner sc = new Scanner(System.in);
	private static char[][] a;
	private static int m;
	private static int n;

	public static void main(String[] args) {
		m = sc.nextInt();
		n = sc.nextInt();
		a = new char[m][];
		for (int i = 0; i < m; i++)
			a[i] = sc.nextLine().toCharArray();
		int num = 0;
		// 遍历数组的每一个角落
		for (int r = 0; r < m; r++)
			for (int c = 0; c < n; c++)
				if (a[r][c] == 'w') {
					// 发现水洼就进行深搜
					bfs(r, c);
					num++;
				}
		System.out.println(num);
	}

	private static void bfs(int r, int c) {
		// 将水洼变成干地，避免重复搜索
		a[r][c] = '.';
		for (int i = -1; i < 2; i++)
			for (int j = -1; j < 2; j++) {
				if (i == 0 && j == 0)
					continue;
				if (r + i >= 0 && r + i < n && c + j >= 0 && c + j < m)
					if (a[r + i][c + j] == 'w')
						// 周围有水洼继续进行深搜
						bfs(r + i, c + j);
			}
	}
}
