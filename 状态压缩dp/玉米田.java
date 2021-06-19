package 状态压缩dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 玉米田 {
	// 状压dp，只与上一层有关，属性Count
	// 第一维代表行数，第二维代表当前行状态
	static int N = 14, M = 1 << N;
	static long[][] f = new long[N][M];
	static List<Integer> state = new ArrayList<Integer>(); // 存储所有合法的状态
	@SuppressWarnings("unchecked")
	static List<Integer>[] head = new ArrayList[M];
	static int[] w = new int[N]; // 用于存储图中每一行的状态
	static int MOD = (int) 1e8;
	static int n, m;

	static boolean check(int x) {
		for (int i = 0; i < m; i++)
			if (((x >> i) & (x >> i + 1)) == 1)
				return false;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] cur = in.readLine().split(" ");
		n = Integer.parseInt(cur[0]);
		m = Integer.parseInt(cur[1]);

		for (int i = 1; i <= n; i++) {
			String[] arr = in.readLine().split(" ");
			// 高位在哪边无所谓
			for (int j = 0; j < m; j++)
				w[i] += (1 - Integer.parseInt(arr[j])) << j;
		}

		for (int i = 0; i < 1 << m; i++)
			head[i] = new ArrayList<Integer>();

		// 枚举所有的合法状态，存储到state中
		for (int i = 0; i < 1 << m; i++)
			if (check(i))
				state.add(i);

		// 枚举当前状态可以从哪些状态转移过来
		for (int i = 0; i < state.size(); i++) {
			for (int j = 0; j < state.size(); j++) {
				int a = state.get(i);
				int b = state.get(j);
				if ((a & b) == 0)
					head[i].add(b);
			}
		}

		f[0][0] = 1;
		for (int i = 1; i <= n + 1; i++) {
			for (int j = 0; j < state.size(); j++) {
				int a = state.get(j);
				for (Integer b : head[j])
					if ((a & w[i]) == 0)
						f[i][a] = (f[i][a] + f[i - 1][b]) % MOD;
			}
		}
		// f[i][0]可以由上一行的任意状态转移过来，所以f[i+1][0]代表前i行的和
		System.out.println(f[n + 1][0]);
	}
}
