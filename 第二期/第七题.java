package 第二期;

import java.util.Scanner;

public class 第七题 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int t = sc.nextInt();
		a = (a + ((t + b) / 60)) % 24;
		b = (b + (t % 60)) % 60;
		System.out.println(a);
		System.out.println(b);
	}
}
