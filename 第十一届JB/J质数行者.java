package 第十一届JB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J质数行者 {

	static final int MOD = 1000000007;
	static int p, prime[], dp[][][];

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		int n = in.nextInt(), m = in.nextInt(), v = in.nextInt(), r1 = in.nextInt(), c1 = in.nextInt(),
				h1 = in.nextInt(), r2 = in.nextInt(), c2 = in.nextInt(), h2 = in.nextInt();
		dp = new int[n + 1][m + 1][v + 1];
		prime = new int[256];
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++)
				Arrays.fill(dp[i][j], -1);
		dp[r1][c1][h1] = dp[r2][c2][h2] = 0;
		dp[1][1][1] = 1;
		prime[p++] = 2;
		agent: for (int i = 3; i < 1000; i += 2) {
			for (int k = 0, h = (int) Math.sqrt(i); prime[k] <= h; k++)
				if (i % prime[k] == 0)
					continue agent;
			prime[p++] = i;
		}
		System.out.println(dfs(n, m, v));
	}

	static int dfs(int x, int y, int z) {
		if (dp[x][y][z] >= 0)
			return dp[x][y][z];
		int res = 0;
		for (int i = 0; i < p; i++) {
			if (x - prime[i] > 0)
				res = (res + dfs(x - prime[i], y, z)) % MOD;
			if (y - prime[i] > 0)
				res = (res + dfs(x, y - prime[i], z)) % MOD;
			if (z - prime[i] > 0)
				res = (res + dfs(x, y, z - prime[i])) % MOD;
		}
		return dp[x][y][z] = res;
	}

	static class InputReader {

		BufferedReader read;
		StringTokenizer tok;
		String delimiters;

		InputReader(InputStream in) {
			this(in, " \n\t\r\f");
		}

		InputReader(InputStream in, String delimiters) {
			this.read = new BufferedReader(new InputStreamReader(in));
			this.delimiters = delimiters;
		}

		String next() {
			while (tok == null || !tok.hasMoreTokens())
				try {
					tok = new StringTokenizer(read.readLine(), delimiters);
				} catch (IOException e) {
					e.fillInStackTrace();
				}
			return tok.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
