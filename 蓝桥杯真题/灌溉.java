package 蓝桥杯真题;

import java.util.HashSet;
import java.util.Scanner;

public class 灌溉 {
	static int n, m, t, k;
	static HashSet<Integer> niu = new HashSet<Integer>();
	static HashSet<Integer> old = new HashSet<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			niu.add(r * 1000 + c);
		}
		k = sc.nextInt();
		bfs();
		System.out.println(niu.size());
		sc.close();
	}

	private static void bfs() {
		for (int i = 0; i < k; i++) {
			for (int x : niu) {
				int r = x / 1000;
				int c = x % 1000;
				for (int j = -1; j <= 1; j++) {
					for (int k = -1; k <= 1; k++) {
						if (Math.abs(j + k) != 1)
							continue;
						if (r + j <= 0 || r + j > n || c + k <= 0 || c + k > m)
							continue;
						old.add((r + j) * 1000 + c + k);
					}
				}
			}
			niu.addAll(old);
			old.clear();
		}
	}
}
