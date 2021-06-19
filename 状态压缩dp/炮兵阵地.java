package 状态压缩dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 炮兵阵地 {
	// 状压dp，属性Count
	// 滚动数组优化，不用head数组，因为涉及到前两层的状态
	// 第一维代表行数，第二维代表上一行的状态，第三维度代表当前行状态
	static int N = 10, M = 1 << N, n, m;
	static int[] cnt = new int[M], w = new int[105];
	static int[][][] f = new int[2][M][M];
	static ArrayList<Integer> state = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);

		for (int i = 1; i <= n; i++) {
			char[] c = in.readLine().toCharArray();
			for (int j = 0; j < m; j++)
				if (c[j] == 'H')
					w[i] += 1 << j;
		}

		for (int i = 0; i < 1 << m; i++) {
			if (check(i)) {
				state.add(i);
				cnt[i] = count(i);
			}
		}

		for (int i = 1; i <= n + 2; i++) {
			for (int j = 0; j < state.size(); j++) {
				for (int k = 0; k < state.size(); k++) {
					int a = state.get(k); // i
					int b = state.get(j); // i-1
					if ((w[i] & a) != 0)
						continue;
					if ((a & b) != 0)
						continue;
					for (int u = 0; u < state.size(); u++) {
						int c = state.get(u); // i-2
						if (((b & c) != 0) || ((a & c) != 0))
							continue;
						f[i & 1][b][a] = Math.max(f[i & 1][b][a], f[i - 1 & 1][c][b] + cnt[a]);
					}
				}
			}
		}
		System.out.println(f[n + 2 & 1][0][0]);
	}

	private static int count(int i) {
		int res = 0;
		for (int j = 0; j < m; j++)
			res += ((i >> j) & 1);
		return res;
	}

	private static boolean check(int x) {
		for (int i = 0; i < m; i++)
			if (((x >> i) & (x >> i + 1)) == 1 || ((x >> i) & (x >> i + 2)) == 1)
				return false;
		return true;
	}
}
