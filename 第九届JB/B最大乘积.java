package 第九届JB;

import java.util.Arrays;

public class B最大乘积 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int add = 0, mul = 1, max = 0;
		for (int i = 0; i < 9; i++) {
			add += arr[i];
			mul *= arr[i];
		}
		do {
			for (int i = 0, l = 0, r, v, a, m; i < 9; i++) {
				l = l * 10 + arr[i];
				r = 0;
				for (int j = i + 1; j < 9; j++)
					r = r * 10 + arr[j];
				v = l * r;
				if (v > max) {
					m = 1;
					a = 0;
					do {
						a += v % 10;
						m *= v % 10;
					} while ((v /= 10) > 0);
					if (m == mul && a == add)
						max = l * r;
				}
			}
		} while (next(arr));
		System.out.print(max);
	}

	static boolean next(int[] a) {
		int i = a.length - 2;
		while (i >= 0 && a[i] > a[i + 1])
			i--;
		if (i < 0)
			return false;
		int j = i + 1, t = a[i];
		while (j < a.length && a[j] > t)
			j++;
		a[i] = a[j - 1];
		a[j - 1] = t;
		Arrays.sort(a, i + 1, a.length);
		return true;
	}
}
