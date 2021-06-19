package 第十届JB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F最长子序列 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		char[] s1 = in.readLine().toCharArray();
		char[] s2 = in.readLine().toCharArray();
		int j = 0, i = 0;
		for (; i < s2.length; i++) {
			char c = s2[i];
			for (; j < s1.length; j++) {
				if (s1[j] == c) {
					if (j == s1.length - 1) {
						System.out.println(i + 1);
						return;
					}
					j++;
					break;
				}
			}
			if (j == s1.length) {
				System.out.println(i);
				break;
			}
		}
	}
}
