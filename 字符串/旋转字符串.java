package 字符串;

import java.util.Scanner;

public class 旋转字符串 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String s1 = sc.nextLine();
		StringBuffer s = new StringBuffer(s1);
//		String s2 = sc.nextLine();
//		if ((s1 + s1).indexOf(s2) == -1) {
//			System.out.println("false");
//		} else {
//			System.out.println("true");
//		}
		if (s1.equals(s.reverse().toString())) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}
}
