package 蓝桥杯真题;

import java.util.Arrays;
import java.util.Scanner;

public class 等差数列 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] a = new int[length];
		for (int i = 0; i < length; i++)
			a[i] = sc.nextInt();
		Arrays.sort(a);
		if (a.length == 1 || a[0] == a[1]) {
			System.out.println(length);
			return;
		}
		int min = Integer.MAX_VALUE;
		int l = a.length;
		for (int i = 0; i < l - 1; i++)
			if (min > a[i + 1] - a[i])
				min = a[i + 1] - a[i];
		System.out.println((a[l - 1] - a[0]) / min + 1);
		sc.close();
	}
}