package 字符串;

import java.util.HashMap;
import java.util.Map;

public class 题目6 {
	public static void main(String[] args) {
		String str1 = "hsjddhjk";
		String str2 = new StringBuffer(str1).reverse().toString();
		if (f(str1, str2))
			System.out.println("yes");
		else
			System.out.println("no");
	}

	private static boolean f(String str1, String str2) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str1.length(); i++) {
			char s = str1.charAt(i);
			if (map.get(s) == null)
				map.put(s, 1);
		}
		for (int i = 0; i < str2.length(); i++) {
			char s = str2.charAt(i);
			if (map.get(s) == null)
				return false;
		}
		return true;
	}
}
