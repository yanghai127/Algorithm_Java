package dfs;

import java.util.Scanner;

public class 走方格 {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int m = in.nextInt();
		int n = in.nextInt();
		int sum = f(m, n);
		System.out.println(sum);
	}

	private static int f(int r, int c) {
		int[] a = new int[c + 1];
		a[1] = 1;
		for (int i = 1; i <= r; i++)
			for (int j = 1; j <= c; j++)
				a[j] += a[j - 1];
		return a[c];
	}
}
