package 蓝桥杯真题;

public class RSA加密 {
	static long n = 1001733993063167141L;
	static long d = 212353;
	static long c = 20190324;
	static long p = 2;
	static long q = 0;
	static long phi;
	static long e = 1;
	static long x1 = 0, y1 = 0;
	static long ans = 1;

	/**
	 * 求解p和q的
	 */
	public static void qiue() {
		while (n % p != 0) {
			p++;
		}
		q = n / p;
	}

	public static long quickmod(long a, long b) {
		long x = 0;
		while (b != 0) {
			if (b % 2 == 1) {
				x = (x + a) % n;
			}
			a = (a + a) % n;
			b /= 2;
		}
		return x;
	}
	// 用快速幂求模，每次求模后余数相乘，得到最后的答案
	// 每当要用到乘法时，用快速乘，再模，求余数

	public static void quickmul(long c, long e) {
		while (e != 0) {
			if (e % 2 == 1) {
				ans = quickmod(ans, c);
			}
			e /= 2;
			c = quickmod(c, c);
		}
	}

	public static void gcd(long i, long j, long a, long b) {
		// 欧几里得扩展求乘法逆元
		if (j == 0) {
			x1 = 1;
			y1 = 0;
			return;
		}

		gcd(j, i % j, x1, y1);
		long temp = x1;
		x1 = y1;
		y1 = temp - i / j * y1;
		e = x1;
		return;

	}

	public static void main(String[] args) {
		// 求解p、q
		qiue();
		phi = (p - 1) * (q - 1);
		gcd(d, phi, x1, y1);
		e = (e + phi) % phi;
		quickmul(c, e);
		System.out.print(ans);
	}
}
