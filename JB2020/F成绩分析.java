package JB2020;

import java.util.Scanner;

public class F成绩分析 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = 0, t = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		double sum = 0;
		n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			t = scanner.nextInt();
			sum += t;
			if (t > max)
				max = t;
			if (t < min)
				min = t;
		}
		System.out.println(max);
		System.out.println(min);
		System.out.printf("%.2f", sum / n);
		scanner.close();
	}
}
