package JB2019;

import java.util.Scanner;

public class I后缀表达式 {
	public static int N, M;
	public static int[] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		a = new int[N + M + 1];
		int min = 0, max = 0;
		for (int x = 0; x < a.length; x++) {
			a[x] = sc.nextInt();
			if (a[min] > a[x]) {
				min = x;
			}
			if (a[max] < a[x]) {
				max = x;
			}
		}
		long sum = 0;

		if (M == 0) {
			for (int x = 0; x < a.length; x++) {
				sum += a[x];
			}
			System.out.println(sum);
		} else {
			for (int x = 0; x < a.length; x++) {
				sum += Math.abs(a[x]);
			}

			sum = (sum - Math.abs(a[max]) - Math.abs(a[min])) + (a[max] - a[min]);
			System.out.println(sum);
		}
		sc.close();
	}
}