package 随便写写;

import java.util.Scanner;

public class 青蛙跳楼梯 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = f(n);
		System.out.println(count);
		sc.close();
	}

	private static int f(int n) {
		if (n == 1 || n == 2)
			return n;
		int x = 1, y = 2;
		for (int i = 3; i <= n; i++) {
			int temp = x;
			x = y;
			y += temp;
		}
		return y;
	}
}
