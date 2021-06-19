package DFS之剪枝与优化;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 数独 {
	static char[] sodoku;
	static int[] row, col;	// 1 availabe, 0 unavailable
	static int[][] cell;
	static int[] ones;		// 存1的个数
	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		ones = new int[1 << 9];
		for (int i = 0; i < 9; i++)
			map.put(1 << i, i);

		for (int i = 0; i < 1 << 9; i++) {
			for (int j = 0; j < 9; j++) {
				ones[i] += i >> j & 1;
			}
		}

		while (true) {
			String temp = in.readLine();
			if (temp.equals("end"))
				break;
			sodoku = temp.toCharArray();
			init();		// 恢复现场
			int count = 81;
			for (int i = 0; i < 9; i++) {	// 遍历每一个格子，布置现场
				for (int j = 0; j < 9; j++) {
					if (sodoku[i * 9 + j] != '.') {
						draw(i, j, sodoku[i * 9 + j] - '1', true);
						count--;
					}
				}
			}
			dfs(count);
			System.out.println(new String(sodoku));
		}
	}

	public static void init() {
		row = new int[9];
		col = new int[9];
		cell = new int[3][3];
		Arrays.fill(row, (1 << 9) - 1); // 8位全一
		Arrays.fill(col, (1 << 9) - 1);
		for (int i = 0; i < 3; i++)
			Arrays.fill(cell[i], (1 << 9) - 1);
	}

	public static void draw(int x, int y, int n, boolean isSet) {
		if (isSet)
			sodoku[x * 9 + y] = (char) ('1' + n);
		else
			sodoku[x * 9 + y] = '.';

		int dv = 1 << n;

		if (!isSet)
			dv = -dv;

		row[x] -= dv;
		col[y] -= dv;
		cell[x / 3][y / 3] -= dv;
	}

	public static int lowbit(int x) {
		return x & -x;
	}

	public static boolean dfs(int cnt) {
		if (cnt == 0)
			return true;
		// 优化搜索顺序，先搜变化少的
		int min = 10, x = -1, y = -1;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sodoku[i * 9 + j] == '.') {
					int options = ones[row[i] & col[j] & cell[i / 3][j / 3]];
					if (options < min) {
						min = options;
						x = i;
						y = j;
					}
				}
			}
		}

		int state = row[x] & col[y] & cell[x / 3][y / 3];

		for (int i = state; i != 0; i -= lowbit(i)) {
			int n = map.get(lowbit(i)); // 可以选n
			draw(x, y, n, true);	// 改变状态
			if (dfs(cnt - 1))
				return true;
			draw(x, y, n, false);	// 恢复现场
		}

		return false;
	}
}
