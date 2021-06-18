package 递归和递推;

import java.util.Scanner;

public class 汉诺塔 {
	static int sum = 0;

	static void f(int n, String a, String b, String c) {
		if (n == 1) {
			System.out.println("move " + n + " from " + a + " to " + b);
			sum++;
			return;
		}
		f(n - 1, a, c, b);
		System.out.println("move " + n + " from " + a + " to " + b);
		sum++;
		f(n - 1, c, b, a);
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		f(sc.nextInt(), "a", "b", "c");
		System.out.println(sum);
	}
}
