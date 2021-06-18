package dfs;

import java.util.Scanner;

public class n皇后问题 {
	static int n, num, a[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n]; // 数组a用于存储皇后位置
		dfs(0);
		System.out.println(num);
		sc.close();
	}

	private static void dfs(int r) {
		if (r == n) {
			num++;
			print();
			return;
		}
		// 每行一个皇后，从第一行开始放，循环每一列
		for (int c = 0; c < n; c++)
			if (check(r, c)) {
				a[r] = c; // 新的数据会把老的覆盖，所以不用回溯
				dfs(r + 1);
			}
	}

	private static boolean check(int r, int c) {
		for (int i = 0; i < r; i++)
			// 判断是否同列、是否在对角线上
			if (a[i] == c || i + a[i] == r + c || i - a[i] == r - c)
				return false;
		return true;
	}

	private static void print() {
		for (int x : a)
			System.out.print(x + " ");
		System.out.println();
	}
}
