package 暴力穷举算法;

import java.util.*;

public class 含2019的正整数求和{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n = sc.nextInt(), ans = 0;
		for (int i = 1; i <= n; ++i) {
			int t = i;
			boolean ok = false;
			while (t != 0) {
				int g = t % 10;
				if (g == 2 || g == 0 || g == 1 || g == 9)
					ok = true;
				t = t / 10;
			}
			if (ok)
				ans += i;
		}
		System.out.println(ans);
	}
}
