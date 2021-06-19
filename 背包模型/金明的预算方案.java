package 背包模型;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 金明的预算方案 {
	// 一维，不超过，最大值，分组背包
	static class Pair {
		// v代表价值，w代表重要程度
		int v;
		int w;

		public Pair(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static int N = 32010, n, m;
	static int[] f = new int[N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		Pair[] master = new Pair[m + 1]; // 存主件的价值和重要程度
		HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
		for (int i = 1; i <= m; i++)
			map.put(i, new ArrayList<>());

		for (int i = 1; i <= m; i++) {
			int v = sc.nextInt();
			int p = sc.nextInt();
			int q = sc.nextInt();
			Pair pair = new Pair(v, v * p);
			if (q == 0) // 主件
				master[i] = pair;
			else
				map.get(q).add(pair);
		}
		// n是资金数，m是组数
		for (int i = 1; i <= m; ++i) {
			if (master[i] == null || master[i].v == 0)
				continue;
			for (int j = n; j >= 0; j--) { // 枚举资金数
				int size = map.get(i).size();
				// 枚举不同附件的组合，状压dp
				for (int k = 0; k < 1 << size; k++) {
					int v = master[i].v;
					int w = master[i].w;
					for (int u = 0; u < size; u++) {
						if ((k >> u & 1) == 1) {
							Pair cur = map.get(i).get(u);
							v += cur.v;
							w += cur.w;
						}
					}
					if (j >= v)
						f[j] = Math.max(f[j], f[j - v] + w);
				}
			}
		}
		System.out.println(f[n]);
		sc.close();
	}
}
