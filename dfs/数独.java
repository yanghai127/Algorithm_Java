package dfs;

import java.util.Scanner;

/* 测试用数字
0 0 5 3 0 0 0 0 0
8 0 0 0 0 0 0 2 0
0 7 0 0 1 0 5 0 0
4 0 0 0 0 5 3 0 0
0 1 0 0 7 0 0 0 6
0 0 3 2 0 0 0 8 0
0 6 0 5 0 0 0 0 9
0 0 4 0 0 0 0 3 0
0 0 0 0 0 9 7 0 0
*/
public class 数独 {
	static int[][] a;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		a = new int[9][9];
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				a[i][j] = in.nextInt();
		dfs(0, 0);
		in.close();
	}
	// 大暴搜
	private static void dfs(int r, int c) {
		// 出口
		if (r == 9) {
			print();
			return; // 结果唯一用System.exit(0)，否则用return
		}
		if (a[r][c] == 0) {
			for (int key = 1; key < 10; key++)
				if (check(r, c, key)) {
					a[r][c] = key;
					dfs(r + (c + 1) / 9, (c + 1) % 9); // good
				}
			a[r][c] = 0; // 回溯并重置，不然check会一直判错
		} else
			dfs(r + (c + 1) / 9, (c + 1) % 9);
	}

	private static boolean check(int r, int c, int key) {
		for (int i = 0; i < 9; i++) {
			// 判断所在行和列是否有key
			if (a[i][c] == key)
				return false;
			if (a[r][i] == key)
				return false;
		}
		for (int i = (r / 3) * 3; i < (r / 3 + 1) * 3; i++)
			for (int j = (c / 3) * 3; j < (c / 3 + 1) * 3; j++)
				// 判断九宫格里是否有key
				if (a[i][j] == key)
					return false;
		return true;
	}

	private static void print() {
		for (int[] x : a) {
			for (int y : x)
				System.out.print(y + " ");
			System.out.println();
		}
	}

}
