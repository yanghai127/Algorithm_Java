package 背包模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 混合背包问题 {
	// 一维，不超过，最大值，混合背包
	static int N = 1002, n, m, INF = 0x3f3f3f3f;
	static int[] f = new int[N];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] s = in.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		for (int i = 1; i <= n; i++) {
			s = in.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			if (c == -1)
				c = 1;
			if (c == 0)
				c = INF;
			for (int j = m; j > 0; j--) // 从大到小循环
				for (int k = 0; k <= c && j >= a * k; k++)
					f[j] = Math.max(f[j], f[j - a * k] + b * k);
		}
		System.out.println(f[m]);
	}
}
