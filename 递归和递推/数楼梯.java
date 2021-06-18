package 递归和递推;

import java.util.Scanner;

public class 数楼梯 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		int sum = f(n);
		System.out.println(sum);
	}

	private static int f(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		return f(n - 1) + (f(n - 2));
	}
}
