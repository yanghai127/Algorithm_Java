package 状态压缩dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 小国王 {
	// 状压dp、棋盘式，求方案数，属性Count
	// dp数组第一维代表行，第二维代表当前国王个数，第三维代表当前行状态(二进制表示状态)
	static int N = 12, M = 110;
	static long[][][] f = new long[N][M][1 << N];
	static ArrayList<Integer> state = new ArrayList<Integer>(); // 用于存储所有合法的状态
	@SuppressWarnings("unchecked")
	static ArrayList<Integer>[] head = new ArrayList[1 << N]; // 用于储存可以转移到当前状态的所有状态
	static int[] cnt = new int[1 << N]; // 存储每一个合法的状态中有多少个1
	static int n, m;

	static boolean check(int x) {
		for (int i = 0; i < n; i++)
			if (((x >> i) & (x >> i + 1)) == 1)
				return false;
		return true;
	}

	static int count(int x) {
		int res = 0;
		// 一共n-1位
		for (int i = 0; i < n; i++)
			res += ((x >> i) & 1);
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] cur = in.readLine().split(" ");
		n = Integer.parseInt(cur[0]);
		m = Integer.parseInt(cur[1]);

		for (int i = 0; i < 1 << n; i++)
			head[i] = new ArrayList<Integer>();

		// 首先预处理出来所有合法的状态,同一行不可以有相邻的骑士
		for (int i = 0; i < 1 << n; i++) {
			if (check(i)) {
				state.add(i);
				cnt[i] = count(i);
			}
		}

		// 枚举当前状态可以从哪些状态转移过来
		for (int i = 0; i < state.size(); i++) {
			int a = state.get(i);
			for (int j = 0; j < state.size(); j++) {
				int b = state.get(j);
				if (((a & b) == 0) && check(a | b))
					head[i].add(b);
			}
		}

		f[0][0][0] = 1;
		// 不能用滚动数组，因为不能完全更新，而且内存够用，时间换空间没必要
		for (int i = 1; i <= n + 1; i++) {
			for (int j = 0; j <= m; j++) {
				for (int k = 0; k < state.size(); k++) {
					int a = state.get(k);
					for (Integer b : head[k])
						if (j >= cnt[a]) // 我称之为最强
							f[i][j][a] += f[i - 1][j - cnt[a]][b];
				}
			}
		}

		System.out.println(f[n + 1][m][0]);
	}
}
