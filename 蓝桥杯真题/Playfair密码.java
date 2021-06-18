package 蓝桥杯真题;

import java.util.Scanner;

public class Playfair密码 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String key = sc.nextLine();
		String str = sc.nextLine();
		char[][] a = new char[6][6];
		a = f1(a, key);
		String mi = f2(a, str);
		System.out.println(mi);
		sc.close();
	}

	private static char[][] f1(char[][] a, String str) {
		int arr[] = new int[40];
		int sl = str.length();
		for (int i = 0; i < sl; i++) {
			char c = str.charAt(i);
			a[i / 5 + 1][i % 5 + 1] = c;
			arr[c - 97] = 1;
		}
		for (int i = sl; i < 25; i++)
			a[i / 5 + 1][i % 5 + 1] = f3(arr);
		return a;
	}

	private static char f3(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			if (arr[i] != 1) {
				arr[i] = 1;
				return (char) ('a' + i);
			}
		return 0;
	}

	private static String f2(char[][] a, String str) {
		StringBuffer s = new StringBuffer();
		char[] c = str.toCharArray();
		int cl = c.length;
		if (str.length() == 1)
			return s.append(str.charAt(str.length() - 1)).toString();
		if (cl == 2)
			return s.append(f4(a, c[0], c[1])).toString();
		for (int i = 0; i < (cl % 2 == 0 ? cl - 2 : cl - 1); i += 2)
			s.append(f4(a, c[i], c[i + 1]));
		if (cl % 2 == 0)
			return s.toString();
		return s.append(str.charAt(cl - 1)).toString();
	}

	private static StringBuffer f4(char[][] a, char c1, char c2) {
		StringBuffer s = new StringBuffer();
		int a1[] = new int[2];
		int a2[] = new int[2];
		boolean aa1 = true;
		boolean aa2 = true;
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				if (a[i][j] == c1) {
					a1[0] = i;
					a1[1] = j;
					aa1 = false;
				}
				if (a[i][j] == c2) {
					a2[0] = i;
					a2[1] = j;
					aa2 = false;
				}
			}
		}
		if (aa1 || aa2 || c1 == c2)
			return s.append(c1).append(c2);
		if (a1[0] == a2[0] || a1[1] == a2[1])
			return s.append(c2).append(c1);
		return s.append(a[a1[0]][a2[1]]).append(a[a2[0]][a1[1]]);
	}

}
