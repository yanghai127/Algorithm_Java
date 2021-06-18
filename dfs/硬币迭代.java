package dfs;

import java.util.Scanner;

// 有多少种组合方式
public class 硬币迭代 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = f(n);
		System.out.println(sum);
		sc.close();
	}

	private static int f(int n) {
		int[] arr = new int[] { 1, 5, 10, 25 };
		int[][] a = new int[4][n + 1];
		// 初始化
		for (int i = 0; i < n + 1; i++)
			a[0][i] = 1;
		for (int i = 0; i < 4; i++)
			a[i][0] = 1;
		// 遍历这个表格的每一个角落，用前面的推后面的，类似上楼梯
		for (int i = 1; i < arr.length; i++)
			for (int j = 1; j < n + 1; j++)
				for (int j2 = 0; j2 * arr[i] <= j; j2++)
					a[i][j] += a[i - 1][j - j2 * arr[i]];
		return a[3][n];
	}

}
