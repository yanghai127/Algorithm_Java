package dfs;

import java.util.Scanner;

public class 困难的串 {
	static Scanner in = new Scanner(System.in);
	static int count, l, n;

	public static void main(String[] args) {
		// n代表字典序数，l代表可用字母数
		l = 3;
		n = 7;
		dfs("");
	}

	private static void dfs(String prefix) {
		for (char c = 'A'; c < 'A' + l; c++) // c<'D'
			if (isHard(prefix, c)) {
				String str = prefix + c;
				System.out.println(str);
				count++;
				if (count == n)
					System.exit(0); // 系统关闭
				dfs(str);
			}
	}

	private static boolean isHard(String prefix, char c) {
		// 判断是否为困难串
		int count = 0;
		for (int j = prefix.length() - 1; j >= 0; j -= 2) {
			// j-2，取后两个是1对1比，取后四个是2对2比，取后六个是3对3比
			String s1 = prefix.substring(j, j + count + 1); // [j,j+count +1)
			String s2 = prefix.substring(j + count + 1) + c; // [j+count+1,length-1]
			if (s1.equals(s2))
				return false;
			count++;
		}
		return true;
	}
}
