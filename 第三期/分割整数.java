package 第三期;

import java.util.Scanner;

public class 分割整数 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		String str = "";
		int count = 1;
		while (n != 0) {
			str += n % 10;
			if (count % 3 == 0) {
				str += ",";
			}
			n /= 10;
			count++;
		}
		StringBuilder sb = new StringBuilder(str);
		if (sb.charAt(sb.length() - 1) == ',') {
			sb.deleteCharAt(sb.length() - 1);
		}
		System.out.println(sb.reverse().toString());
		sc.close();
	}
}
