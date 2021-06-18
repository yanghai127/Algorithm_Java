package 暴力穷举算法;

import java.util.Scanner;

public class 次数差 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String str = sc.next();
		int maxx = 0, minn = 0x3f3f3f3f;
		char[] a = str.toCharArray();
		int[] b = new int[26];
		for (char x : a) {
			b[x - 97]++;
		}
		for (int y : b) {
			if (y != 0) {
				maxx = (maxx > y) ? maxx : y;
				minn = (minn < y) ? minn : y;
			}
		}
		System.out.println(maxx - minn);
	}
}
