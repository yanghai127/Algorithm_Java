package 蓝桥杯模拟题;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class 拯救Andy_优化1 {
	static int n, m, p;
	static int[][] a;
	static HashSet<Integer> h = new HashSet<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		p = sc.nextInt();
		a = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(a[i], -2);
		}
		for (int i = 0; i < m; i++) {
			a[sc.nextInt()][sc.nextInt()] = -1;
		}
		for (int i = 0; i < p; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			h.add(r * 10000 + c);
			a[r][c] = 0;
		}
		for (int x : h) {
			int r = x / 10000;
			int c = x % 10000;
			bfs(r, c);
		}
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (a[i][j] != -2) {
					sum += a[i][j];
				} else {
					sum -= 1;
				}
			}
		}
		System.out.println(sum);
		sc.close();
	}

	private static void bfs(int rr, int cc) {
		boolean[][] b = new boolean[n + 1][n + 1];
		b[rr][cc] = true;
		HashSet<Integer> niu = new HashSet<Integer>();
		HashSet<Integer> old = new HashSet<Integer>();
		niu.add(rr * 10000 + cc);
		int count = 1;
		while (niu.size() != 0) {
			for (int x : niu) {
				int r = x / 10000;
				int c = x % 10000;
				for (int i = -1; i < 2; i++) {
					for (int j = -1; j < 2; j++) {
						if (i == 0 && j == 0) {
							continue;
						}
						if (r + i < 1 || r + i > n || c + j < 1 || c + j > n || a[r + i][c + j] == -1) {
							continue;
						}
						if (b[r + i][j + c]) {
							continue;
						}
						int index = (r + i) * 10000 + j + c;
						old.add(index);
						b[r + i][j + c] = true;
						if (a[i + r][j + c] < 0)
							a[i + r][j + c] = count;
						else
							a[i + r][j + c] = a[i + r][j + c] > count ? count : a[i + r][j + c];
					}
				}
			}
			niu.clear();
			niu.addAll(old);
			old.clear();
			count++;
		}
		return;
	}

}
