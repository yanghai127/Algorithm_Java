package 蓝桥杯真题;

import java.util.Scanner;

public class 最长子序列 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int j = 0, num = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (j == s2.length()) {
				break;
			}
			if (s1.charAt(i) == s2.charAt(j)) {
				j++;
				num++;
			}
		}
		System.out.println(num);
		sc.close();
	}
}
