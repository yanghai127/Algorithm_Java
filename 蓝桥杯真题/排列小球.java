package 蓝桥杯真题;

import java.util.Arrays;
import java.util.Scanner;

public class 排列小球 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int ans = 1;
		int[] a = new int[3];
		for (int i = 0; i < 3; i++) {
			a[i] = scan.nextInt();
		}
		Arrays.sort(a);
		for (int i = 1; i < 20; i++) {
			int num1 = a[2] - a[1] - i;
			if (num1 < a[0] || num1 < a[1])
				if (num1 > 0)
					ans++;
			int num2 = a[1] - a[0] - i;
			if (num2 > 0 && num2 < a[0])
				ans++;
		}
		System.out.println(ans);
		scan.close();
	}
}
