package 暴力穷举算法;

import java.util.Scanner;

public class 鸡兔同笼 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		int a = sc.nextInt();

		if (a % 2 == 1) {
			System.out.print(0 + " " + 0);
		} else {
			System.out.print((a / 4 + a % 4 / 2) + " " + a / 2);
		}
	}
}
