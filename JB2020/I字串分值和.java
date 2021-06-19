package JB2020;

import java.util.ArrayList;
import java.util.Scanner;

public class I字串分值和 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		ArrayList<String> list = f(str); // 求所有子串，不需要去重
		int ans = 0;
		for (String s : list)
			ans += f2(s);
		System.out.println(ans);
		sc.close();
	}

	private static ArrayList<String> f(String str) {
		ArrayList<String> set = new ArrayList<String>();
		int sl = str.length();
		for (int i = 0; i < sl; i++)
			for (int j = i + 1; j <= sl; j++)
				set.add(str.substring(i, j));
		return set;
	}

	private static int f2(String s) {
		int[] a = new int[130];
		int num = 0;
		char[] arr = s.toCharArray();
		for (char c : arr)
			a[c] = 1;
		for (int x : a)
			if (x == 1)
				num += 1;
		return num;
	}
}
