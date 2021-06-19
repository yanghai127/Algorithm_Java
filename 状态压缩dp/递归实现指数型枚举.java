package 状态压缩dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 递归实现指数型枚举 {
	// 快速输入输出实现，不然会超时
	static int N = 17, n;
	static boolean[] st = new boolean[N];
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		dfs(1);
		out.flush();
	}

	private static void dfs(int u) throws IOException {
		if (u > n) {
			for (int i = 1; i <= n; i++)
				if (st[i])
					out.write(i + " ");
			out.write("\n");
			return;
		}
		st[u] = true;
		dfs(u + 1);

		st[u] = false;
		dfs(u + 1);
	}
}
