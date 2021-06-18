package 蓝桥杯真题;

import java.util.HashSet;
import java.util.Scanner;

public class 拯救Andy {
	static int n, m, p;
	static int[][] a;
	static HashSet<Integer> s = new HashSet<Integer>();
	static HashSet<Integer> h = new HashSet<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		p = sc.nextInt();
		for (int i = 0; i < m; i++) {
			s.add(sc.nextInt() * 10000 + sc.nextInt());
		}
		for (int i = 0; i < p; i++) {
			h.add(sc.nextInt() * 10000 + sc.nextInt());
		}
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sum += bfs(i, j);
			}
		}
		System.out.println(sum);
		sc.close();
	}

	private static int bfs(int ri, int ci) {
		int index = ri * 10000 + ci;
		if (s.contains(index)) {
			return -1;
		}
		if (h.contains(index)) {
			return 0;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		HashSet<Integer> temp = new HashSet<Integer>();
		set.add(index);
		for (int count = 1; set.size() != 0; count++) {
			for (int x : set) {
				int r = x / 10000;
				int c = x % 10000;
				for (int i = -1; i < 2; i++) {
					for (int j = -1; j < 2; j++) {
						if (i == 0 && j == 0) {
							continue;
						}
						int id = (r + i) * 10000 + c + j;
						if (r + i < 1 || r + i > n || c + j < 1 || c + j > n || s.contains(id)) {
							continue;
						}
						if (h.contains(id)) {
							return count;
						} else {
							temp.add(id);
						}
					}
				}
			}
			set.clear();
			set.addAll(temp);
			temp.clear();
		}
		return -1;
	}
}
