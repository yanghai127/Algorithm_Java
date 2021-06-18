package 模拟赛3_20;

import java.util.Scanner;

public class E {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int start = sc.nextInt();
		int step = sc.nextInt();
		char[] c = str.toCharArray();
		for (int i = start; i < c.length; i += step)
			System.out.print(c[i]);
		sc.close();
	}
}
