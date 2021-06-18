package 蓝桥杯真题;

import java.util.Scanner;

public class 数列与黄金分割_非递归 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double ans = 1.0;
		int a = 1, b = 1, c;
		if (n < 20) {
			for (int i = 1; i < n; i++) {
				c = a + b;
				a = b;
				b = c;
				ans = a / (b + 0.0);
			}
			System.out.printf("%.8f\n", ans);
		} else {
			System.out.println("0.61803399");
		}
		sc.close();
	}
}