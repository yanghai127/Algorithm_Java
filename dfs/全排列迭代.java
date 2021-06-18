package dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class 全排列迭代 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String str = sc.nextLine();
		ArrayList<String> a = f(str);
		a.forEach(obj -> System.out.println(obj));
		System.out.println(a.size());
	}

	private static ArrayList<String> f(String str) {
		int n = str.length();
		ArrayList<String> a = new ArrayList<>();
		a.add(str.charAt(0) + "");
		for (int i = 1; i < n; i++) {
			ArrayList<String> a_new = new ArrayList<>();
			char c = str.charAt(i);
			for (String s : a)
				for (int j = 0; j <= s.length(); j++) {
					// 第j个字符属于等号右侧
					String news = s.substring(0, j) + c + s.substring(j);
					a_new.add(news);
				}
			// 更新集合a
			a = a_new;
		}
		return a;
	}
}
