package JB2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class E迷宫 {
	// Flood Fill算法
	// 利用键值对储存每个点的最小字典序走法，共有454个点可以走到
	static int m = 30, n = 50;
	static char a[][] = new char[m][n];
	static boolean st[] = new boolean[6000];
	static HashMap<Integer, String> old = new HashMap<Integer, String>();
	static HashMap<Integer, String> niu = new HashMap<Integer, String>();
	static String ans = "";

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < m; i++)
			a[i] = in.readLine().toCharArray();

		old.put(0, "");
		while (true) {
			for (int t : old.keySet()) {
				if (!st[t]) {
					st[t] = true;
					if (bfs(t / 100, t % 100, old.get(t))) {
						System.out.println(ans);
						return;
					}
				}
			}
			// 注意不能用等号,只能用整体赋值
			old.clear();
			old.putAll(niu);
			niu.clear();
		}
	}

	// 每一次调用bfs都会把已知点的所有下一步路径走完
	static boolean bfs(int i, int j, String str) {
		boolean ok = false;
		for (int k = -1; k <= 1; k++) {
			for (int s = -1; s <= 1; s++) {
				if (Math.abs(k + s) != 1)
					continue;
				int x = k + i;
				int y = s + j;
				if (x < 0 || y < 0 || x >= m || y >= n || a[x][y] == '1')
					continue;

				int index = x * 100 + y;
				String nstr = str + f(k, s);
				// 当用不同路径走到同一位置时，保存字典序小的走法
				if (niu.containsKey(index)) {
					if (nstr.compareTo(niu.get(index)) < 0)
						niu.put(index, nstr);
				} else
					niu.put(index, nstr);

				if (x == m - 1 && y == n - 1) {
					ok = true;
					if (ans.equals(""))
						ans = nstr;
					else if (ans.compareTo(nstr) > 0)
						ans = nstr;
				}
				
			}
		}
		return ok;
	}

	// 注意坐标原点在左上角
	static String f(int x, int y) {
		if (x == 1)
			return "D";
		else if (x == -1)
			return "U";
		else if (y == 1)
			return "R";
		else
			return "L";
	}
}
