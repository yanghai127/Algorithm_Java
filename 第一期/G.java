package 第一期;

import java.util.Scanner;

public class G {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int m = sc.nextInt();
		int d = sc.nextInt();
		if (m > 12) {
			System.out.println("no");
		} else {
			if (d > a[m]) {
				System.out.println("no");
			} else {
				System.out.println("yes");
			}
		}
		sc.close();
	}
}
