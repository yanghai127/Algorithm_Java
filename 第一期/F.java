package 第一期;

import java.util.Scanner;

public class F {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double res = sc.nextInt() * sc.nextInt() / 2.0;
		System.out.println(res == (int) (res) ? (int) res : Math.round(res*100)*0.01d);
		sc.close();
	}
}
