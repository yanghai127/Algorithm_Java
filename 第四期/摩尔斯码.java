package 第四期;

import java.util.Scanner;

public class 摩尔斯码 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = new String[] { "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..",
				"----." };
		int n = sc.nextInt();
		String[] a = new String[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.next();
			char[] c = a[i].toCharArray();
			String s = "";
			for (int j = 0; j < c.length; j++)
				s += str[c[j] - 48];
			a[i] = s;
		}
		for (String s : a)
			System.out.println(s);
		sc.close();
	}
}
