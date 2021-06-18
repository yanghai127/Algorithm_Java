package 背包九讲;

import java.util.Scanner;
import java.util.TreeSet;

public class 乘船问题 {
	static int c, n;
	static TreeSet<Integer> w;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		c = sc.nextInt();
		n = sc.nextInt();
		w = new TreeSet<Integer>();
		for (int i = 0; i < n; i++)
			w.add(sc.nextInt());
		int count = f();
		System.out.println(count);
		sc.close();
	}

	private static int f() {
		int count = 0;
		while (w.size() != 0) {
			if (w.floor(c - w.first()) == null) {
				count++;
				w.remove(w.first());
			} else {
				count++;
				w.remove(w.first());
				w.remove(w.floor(c - w.first()));
			}
		}
		return count;
	}
}
