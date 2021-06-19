package 基础要打牢;

import java.util.Scanner;

public class 欧几里德 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(gcd(a, b));
		sc.close();
	}

	private static int gcd(int a, int b) {
		int maxx = Math.max(a, b);
		int minn = Math.min(a, b);
		while (maxx % minn != 0) {
			int c = maxx % minn;
			maxx = minn;
			minn = c;
		}
		return minn;
	}
}
