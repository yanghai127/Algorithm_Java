package 第三期;

import java.util.Scanner;

public class 斐波那契 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		n %= 3;
		n = n == 2 ? 1 : n;
		System.out.println(n);
		sc.close();
	}
}
