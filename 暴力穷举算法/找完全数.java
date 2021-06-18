package 暴力穷举算法;

import java.util.Scanner;

public class 找完全数 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					sum += j;
				}
			}
			if (sum == i)
				System.out.print(i + " ");
		}

	}
}
