package 暴力穷举算法;

import java.util.Scanner;

public class 最大乘积 {
	static Scanner sc = new Scanner(System.in);
	public static final int MOD = 1000000009;

	public static void main(String[] args) {
		int n = sc.nextInt();
		int k = sc.nextInt();
		long[] a = new long[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextLong();
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] < a[j + 1]) {
					long num = a[j];
					a[j] = a[j + 1];
					a[j + 1] = num;
				}
			}
		}
		long num = 1;
		for (int i = 0; i < k; i++) {
			num *= (a[i] % MOD);
		}
		System.out.println(num % MOD);
	}
}
