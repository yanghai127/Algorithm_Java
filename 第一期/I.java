package 第一期;

import java.util.Scanner;

public class I {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++)
			a[i] = sc.nextInt();
		int maxx = Integer.MIN_VALUE;
		for (int i = 1; i < a.length; i++)
			if (a[i] - a[i - 1] > maxx)
				maxx = a[i] - a[i - 1];
		System.out.println(maxx);
		sc.close();
	}
}
