package JB2020;

import java.util.Scanner;

public class A门牌制作 {
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			cheak(i);
		}
		System.out.println(ans);
		sc.close();
	}

	private static void cheak(int i) {
		while (i != 0) {
			if (i % 10 == 2) {
				ans++;
			}
			i /= 10;
		}
	}
}
