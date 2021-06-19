package JB2020;

import java.util.Scanner;

public class G单词分析 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] c = str.toCharArray();
		int[] a = new int[30];
		int l = c.length;
		for (int i = 0; i < l; i++) {
			a[c[i] - 96]++;
		}
		int max = 0, index = 0;
		for (int i = 0; i < l; i++) {
			if (a[i] > max) {
				max = a[i];
				index = 96 + i;
			}
		}
		System.out.println((char) index + "\n" + max);
		sc.close();
	}
}
