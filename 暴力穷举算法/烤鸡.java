package 暴力穷举算法;

import java.util.Scanner;

public class 烤鸡 {
	static Scanner sc = new Scanner(System.in);
	static int n, kind = 0;
	static int[][] m1 = new int[10000][10];
	static int[] m2 = new int[10];

	private static void f(int sum, int a) {
		if (a == 10) {
			if (sum == n) {
				System.arraycopy(m2, 0, m1[kind], 0, 10);
				kind++;
			}
		} else if (sum < n)
			for (int i = 1; i <= 3; i++) {
				m2[a] = i;
				f(sum + i, a + 1);
			}
	}

	public static void main(String[] args) {
		n = sc.nextInt();
		f(0, 0);
		System.out.println(kind);
		for (int j = 0; j < kind; j++) {
			for (int i = 0; i < 10; i++)
				System.out.print(m1[j][i] + " ");
			System.out.println();
		}
	}

}
