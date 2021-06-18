package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 电话号码的字母组合 {
	// LeetCode 17
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String str = sc.nextLine();
		ArrayList<String> list = letterCombinations(str);
		list.forEach(obj -> System.out.println(obj));
		System.out.println(list.size());
	}

	private static ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> combinations = new ArrayList<String>();
		if (digits.length() == 0)
			return combinations;
		@SuppressWarnings("serial")
		HashMap<Character, String> phoneMap = new HashMap<Character, String>() {
			{
				put('2', "abc");
				put('3', "def");
				put('4', "ghi");
				put('5', "jkl");
				put('6', "mno");
				put('7', "pqrs");
				put('8', "tuv");
				put('9', "wxyz");
			}
		};
		backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
		return combinations;
	}

	private static void backtrack(ArrayList<String> combinations, HashMap<Character, String> phoneMap, String digits,
			int index, StringBuffer combination) {
		// 出口
		if (index == digits.length()) {
			combinations.add(combination.toString());
			return;
		}
		char digit = digits.charAt(index);
		String letters = phoneMap.get(digit);
		int lettersCount = letters.length();
		for (int i = 0; i < lettersCount; i++) {
			combination.append(letters.charAt(i));
			backtrack(combinations, phoneMap, digits, index + 1, combination);
			combination.deleteCharAt(index); // 回溯后重置
		}
	}
}
