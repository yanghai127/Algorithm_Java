package 字符串;

import java.util.Scanner;

public class 除去k个0 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String str = sc.nextLine();
		String s = str.replaceAll("000", "");
		System.out.println(s);
	}
}
