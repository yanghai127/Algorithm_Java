package 欧拉函数;

import java.util.Arrays;
import java.util.Scanner;

public class RSA公钥私钥 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long p, q;
		System.out.println("请依次输入p、q的值：");
		p = sc.nextInt();
		q = sc.nextInt();
		while (gcd(Math.max(p, q), Math.min(p, q)) != 1) {
			System.out.println("p与q不互质，请重新输入：");
			p = sc.nextInt();
			q = sc.nextInt();
		}

		long N = p * q;
		System.out.println("N：" + N);
		long n = phi(N);
		System.out.println("phi(N)：" + n);
		System.out.println("请选择公钥(小于phi(N)且与phi(N)互质的非负整数)：");
		long[] w = new long[101];
		int idx = 0;
		for (int i = 2; i < n; i++) {
			if (gcd(n, i) == 1)
				w[idx++] = i;
			if (idx == 101)
				break;
		}
		System.out.println(Arrays.toString(w));
		int e = sc.nextInt();
		while (gcd(n, e) != 1) {
			System.out.println("f(N)与e不互质：");
			e = sc.nextInt();
		}

		w = new long[101];
		idx = 0;
		long d = 0;
		for (int i = 1; i < Long.MAX_VALUE; i++) {
			if ((i * n + 1) % e == 0) {
				d = (i * n + 1) / e;
				w[idx++] = d;
			}
			if (idx == 101)
				break;
		}
		System.out.println("公钥：{" + e + " " + N + "}");
		System.out.println("私钥可从以下数组任选：");
		System.out.println(Arrays.toString(w));
		System.out.println("end");
		sc.close();
	}

	private static long gcd(long l, long m) {
		return l % m == 0 ? m : gcd(m, l % m);
	}

	static long phi(long n) {
		long res = n;
		for (int i = 2; i <= n / i; i++)
			if (n % i == 0) {
				res = res / i * (i - 1);
				while (n % i == 0)
					n /= i;
			}
		if (n > 1)
			res = res / n * (n - 1);

		return res;
	}

}
