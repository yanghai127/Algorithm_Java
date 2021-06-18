package 蓝桥杯真题;

import java.util.Scanner;

public class 特别数的和 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			if (cheak(i)) {
				sum += i;
			}
		}
		System.out.println(sum);
		sc.close();
	}

	private static boolean cheak(int n) {
		while (n != 0) {
			int a = n % 10;
			if (a == 2 || a == 0 || a == 1 || a == 9) {
				return true;
			}
			n /= 10;
		}
		return false;
	}
}
