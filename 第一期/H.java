package 第一期;

import java.util.Scanner;

public class H {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(sc.next());
		int t = sc.nextInt();
		for (int i = 0; i < t; i++)
			for (int j = 0; j < sb.length() - 1; j++)
				if (sb.charAt(j) > sb.charAt(j + 1)) {
					sb.deleteCharAt(j);
					break;
				} else if (j == sb.length() - 2)
					sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
		sc.close();
	}
}
