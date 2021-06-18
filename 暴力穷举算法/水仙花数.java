package 暴力穷举算法;

import java.util.Scanner;

public class 水仙花数 {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n = sc.nextInt();
		for (int i = 0; i <= n; i++) {
			int sum = 0, d = 0, x = i, arr[] = new int[10];
			while (x != 0) {
				arr[d++] = x % 10;
				x /= 10;
			}
			for (int j = 0; j < d; j++) {
				sum += Math.pow(arr[j], d);
			}
			if (sum == i)
				System.out.print(i + " ");
		}
	}
}
