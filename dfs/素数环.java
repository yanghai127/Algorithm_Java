package dfs;

import java.util.Scanner;

public class 素数环 {
	// dfs，不断尝试，不行就回溯
	static int n, a[], sum;
	static boolean[] b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		b = new boolean[n + 1];
		a[0] = 1;
		dfs(1);
		System.out.println(sum);
		sc.close();
	}

	private static void dfs(int index) {
		// 出口
		if (index == n && isP(a[0] + a[n - 1])) {
			print(a);
			sum++;
			return;
		}
		// 核心代码
		for (int num = 2; num <= n; num++)
			if (!b[num] && isP(a[index - 1] + num)) {
				a[index] = num;
				b[num] = true;
				dfs(index + 1);
				b[num] = false;
			}
	}

	private static boolean isP(int n) {
		for (int i = 2; i * i <= n; i++)
			if (n % i == 0)
				return false;
		return true;
	}

	private static void print(int[] a) {
		for (int x : a)
			System.out.print(x + " ");
		System.out.println();
	}
}
