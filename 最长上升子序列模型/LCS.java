package 最长上升子序列模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/*
求最长公共子序列
13456778
357486782
*/
public class LCS {
	static BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	static String s1, s2;
	static int[][] f;
	static TreeSet<String> set = new TreeSet<String>();

	public static void main(String[] args) throws IOException {
		s1 = in.readLine();
		s2 = in.readLine();
		int count = dp();
		System.out.println(count);
		set.forEach(obj -> System.out.println(obj));
	}

	private static int dp() {
		int l1 = s1.length();
		int l2 = s2.length();
		f = new int[l1 + 1][l2 + 1];
		// 核心代码
		for (int i = 1; i <= l1; i++)
			for (int j = 1; j <= l2; j++)
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					f[i][j] = f[i - 1][j - 1] + 1;
				else
					f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
		
		f(l1, l2, new String());
		return f[l1][l2];
	}

	private static void f(int i, int j, String str) {
		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				str += s1.charAt(i - 1);
				i--;
				j--;
			} else {
				if (f[i - 1][j] > f[i][j - 1])
					i--;
				else if (f[i - 1][j] < f[i][j - 1])
					j--;
				else {
					f(i - 1, j, str);
					f(i, j - 1, str);
					return;
				}
			}
		}
		StringBuilder sB = new StringBuilder(str).reverse();
		set.add(sB.toString());
	}
}
