package 第十一届JB;

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F蓝肽子序列 {
	// 滚动数组不能用，应该有坑
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
//		System.setOut(new PrintStream(new FileOutputStream("incc.txt"))); // 输出重定向
		String s1 = in.readLine();
		String s2 = in.readLine();
		String[] arr1 = getArr(s1);
		String[] arr2 = getArr(s2);
		System.out.println(lcs(arr1, arr2));
	}

	private static int lcs(String[] arr1, String[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		int[][] f = new int[n][m];

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (arr1[i].equals(arr2[j]))
					f[i][j] = f[i - 1][j - 1] + 1;
				else
					f[i][j] = max(f[i - 1][j], f[i][j - 1]);
			}
		}
		return f[n - 1][m - 1];
	}

	static String[] getArr(String s1) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s1.length(); i++) {
			char char_i = s1.charAt(i);
			if (char_i >= 'A' && char_i <= 'Z')
				sb.append(" ").append(char_i);
			else
				sb.append(char_i);
		}
		return sb.toString().split(" ");
	}
}