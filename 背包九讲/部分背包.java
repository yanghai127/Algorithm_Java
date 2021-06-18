package 背包九讲;

import java.util.Scanner;
import java.util.TreeMap;

public class 部分背包 {
	static int c, n;
	static int[] w, v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		c = sc.nextInt();
		n = sc.nextInt();
		w = new int[n + 1];
		v = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		double sum = f();
		System.out.println(sum);
		sc.close();
	}

	private static double f() {
		double sum = 0;
		TreeMap<Double, Integer> map = new TreeMap<Double, Integer>();
		for (int i = 1; i <= n; i++) {
			double value = v[i] / (w[i] * 1.0);
			map.put(value, i);
		}
		for (int i = 1; i <= n; i++) {
			Double key = map.lastKey();
			if (c >= w[map.get(key)]) {
				sum += v[map.get(key)];
				c -= w[map.get(key)];
				map.remove(key);
			} else {
				sum += c * key;
				break;
			}
		}
		return sum;
	}
}
