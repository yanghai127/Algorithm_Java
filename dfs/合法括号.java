package dfs;

import java.util.Scanner;

public class 合法括号 {
	// 或者用卡特兰数，做半个矩阵dfs
	static int n, count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dfs(0, 0);
		System.out.println(count);
		sc.close();
	}

	private static void dfs(int i, int j) {
		if (i == n) {
			count++;
			return;
		}
		if (i < n) {
			if (i == j) {
				dfs(i + 1, j);
			} else {
				dfs(i + 1, j);
				dfs(i, j + 1);
			}
		}

	}
}
