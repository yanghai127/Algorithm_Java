package 蓝桥杯真题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class 外卖店优先级 {
	static int n, m, t;
	static int[] map;
	static HashMap<Integer, ArrayList<Integer>> map_t = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
		map = new int[n + 1];
		for (int i = 0; i < m; i++) {
			int key = sc.nextInt();
			if (map_t.get(key) != null) {
				map_t.get(key).add(sc.nextInt());
			} else {
				ArrayList<Integer> a = new ArrayList<Integer>();
				a.add(sc.nextInt());
				map_t.put(key, a);
			}
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 1; i <= t; i++) {
			if (map_t.get(i) != null) {
				ArrayList<Integer> a = map_t.get(i);
				for (int x : a)
					map[x] += 3;
			}

			for (int j = 1; j <= n; j++) {
				if (map[j] > 0) {
					map[j] -= 1;
					if (map[j] > 5)
						set.add(j);
					if (map[j] < 4)
						set.remove(j);
				}
			}
		}
		System.out.println(set.size());
		sc.close();
	}
}
