package JB2020;

import java.util.ArrayList;

// 并查集
public class D七段码 {
	static int ans = 0;
	static int[] use = new int[8]; // 用于
	static int[][] map = new int[8][8];
	static int[] father = new int[8];

	public static void main(String[] args) {
		// 储存关系 a~g对应1~7
		map[1][2] = map[2][1] = 1;// a b
		map[1][6] = map[6][1] = 1;// a f
		map[2][7] = map[7][2] = 1;// b g
		map[2][3] = map[3][2] = 1;// b c
		map[3][4] = map[4][3] = 1;// c d
		map[3][7] = map[7][3] = 1;// c g
		map[4][5] = map[5][4] = 1;// d e
		map[5][6] = map[6][5] = 1;// e f
		map[5][7] = map[7][5] = 1;// e g
		map[6][7] = map[7][6] = 1;// f g
		dfs(0);
		System.out.print(ans);
	}

	public static void dfs(int n) {
		if (n == 7) {
			ArrayList<Integer> a = new ArrayList<>();
			for (int i = 1; i <= 7; i++)
				if (use[i] == 1)
					a.add(i);
			// 判断是否相连
			if (a.size() != 0)
				if (judge(a))
					ans++;
			a.clear();
			return;
		}
		// dfs灯情况
		use[n + 1] = 1;
		dfs(n + 1);
		use[n + 1] = 0;
		dfs(n + 1);
	}

	public static boolean judge(ArrayList<Integer> a) {
		// 并查集父集重置
		for (int i = 0; i < 8; i++)
			father[i] = i;
		// 并集
		for (int i = 0; i < a.size(); i++)
			for (int ii = 0; ii < a.size(); ii++)
				// 如果两边相连的话 进行并集操作
				if (map[a.get(i)][a.get(ii)] == 1) {
					int fx = find(a.get(i));
					int fy = find(a.get(ii));
					if (fx != fy)
						father[fx] = fy;
				}
		// 查看是否都属于一个集合
		int temp = find(a.get(0));
		for (int i = 1; i < a.size(); i++)
			if (find(a.get(i)) != temp)
				return false;
		return true;
	}

	// 查集
	public static int find(int x) {
		return father[x] == x ? x : (father[x] = find(father[x]));
	}
}
