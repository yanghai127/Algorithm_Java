package 蓝桥杯真题;

import java.util.Scanner;
import java.text.DecimalFormat;

public class 数列与黄金分割 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n < 20) {// 超时处理
			double r = (double) fb(n) / (double) fb(n + 1);
			DecimalFormat df = new DecimalFormat("0.00000000");// 保留8位小数
			String s = df.format(r);
			System.out.println(s);
		} else
			System.out.println("0.61803399");
		sc.close();
	}

	public static int fb(int n) {
		if (n < 2) {
			return n == 1 ? 1 : 0;
		}
		return fb(n - 1) + fb(n - 2);
	}
}