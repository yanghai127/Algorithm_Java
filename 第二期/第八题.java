package 第二期;

import java.util.HashSet;
import java.util.Scanner;

public class 第八题 {
	static int n, m, t, k;
	static boolean[][] a;
	static HashSet<Integer> set = new HashSet<Integer>();
	static HashSet<Integer> niu = new HashSet<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
		a = new boolean[n + 1][m + 1];
		for (int i = 0; i < t; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			set.add(r * 1000 + c);
		}
		k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			for (int x : set) {
				int r = x / 1000;
				int c = x % 1000;
				if (!a[r][c])
					dfs(r, c);
			}
			set.addAll(niu);
			niu.clear();
		}
		System.out.println(set.size());
		sc.close();
	}

	private static void dfs(int r, int c) {
		a[r][c] = true;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (Math.abs(i + j) != 1) {
					continue;
				}
				if (r + i < 1 || r + i > n || c + j < 1 || c + j > m) {
					continue;
				}
				if (!a[r + i][j + c]) {
					niu.add((r + i) * 1000 + c + j);
				}
			}
		}
	}
}
