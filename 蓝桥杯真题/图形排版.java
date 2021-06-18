package 蓝桥杯真题;

import java.util.Scanner;

public class 图形排版 {
	static int m, n;
	static int[] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = new int[n + 1];
		m = sc.nextInt();
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt() * 1000 + sc.nextInt();
		}
		
		sc.close();
	}
}
