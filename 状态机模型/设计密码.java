package 状态机模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 设计密码 {
	// 前驱选后继
	static int N = 55;
	static int[] ne = new int[N];
	static int[][] f = new int[N][N];
	static int[][] jump = new int[N][N];
	static int MOD = (int) 1e9 + 7;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String p = in.readLine();

		// 求next数组
		for (int i = 2, j = 0; i < p.length(); i++) {
			while (j != 0 && p.charAt(i - 1) != p.charAt(j))
				j = ne[j];
			if (p.charAt(i - 1) == p.charAt(j))
				j++;
			ne[i] = j;
		}

		for (int i = 0; i < p.length(); i++) {
			for (char k = 'a'; k <= 'z'; k++) {
				int u = i;
				while (u != 0 && k != p.charAt(u))
					u = ne[u];
				if (p.charAt(u) == k)
					u++;
				jump[i][k - 'a'] = u;
			}
		}

		f[0][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < p.length(); j++) {
				for (char k = 'a'; k <= 'z'; k++) {
					int u = jump[j][k - 'a'];
					if (u < p.length())
						f[i + 1][u] = (int) (((long) f[i + 1][u] + f[i][j]) % MOD);
				}
			}
		}

		int res = 0;
		for (int i = 0; i < p.length(); i++)
			res = (int) ((long) res + f[n][i]) % MOD;
		System.out.println(res);
	}
}
