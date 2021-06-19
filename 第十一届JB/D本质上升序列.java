package 第十一届JB;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class D本质上升序列 {
	// 属性：count
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("11D.txt")); // 输入流重定向
		String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
		int[] f = new int[27];

		for (int i = 1; i <= 200; i++) {
			int now = str.charAt(i - 1) - 'a' + 1;
			f[now] = 1;
			for (int j = 1; j < now; j++)
				f[now] += f[j];
		}

		int res = 0;
		for (int i = 1; i <= 26; i++)
			res += f[i];
		System.out.println(res);
	}
}
