package JB2020;

import java.util.Scanner;

public class B寻找2020 {
	static int ans = 0;
	static int[][] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = new int[7][7];
		for (int i = 1; i < 7; i++) {
			for (int j = 1; j < 7; j++) {
				a[i][j]=sc.nextInt();
			}
		}
		for (int i = 1; i < 7; i++) {
			for (int j = 1; j < 7; j++) {
				if (a[i][j] == 2) {
					cheak(i, j);
				}
			}
		}
		System.out.println(ans);
		sc.close();
	}

	private static void cheak(int i, int j) {
		if (j <= 3) {
			if (a[i][j + 1] == 0 && a[i][j + 2] == 2 && a[i][j + 3] == 0) {
				ans++;
			}
		}
		if (i <= 3) {
			if (a[i + 1][j] == 0 && a[i + 2][j] == 2 && a[i + 3][j] == 0) {
				ans++;
			}
		}
		if (i <= 3 && j <= 3) {
			if (a[i + 1][j + 1] == 0 && a[i + 2][j + 2] == 2 && a[i + 3][j + 3] == 0) {
				ans++;
			}
		}
	}
}
