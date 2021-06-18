package 蓝桥杯真题;

import java.math.BigInteger;
import java.util.Scanner;

public class 斐波那契 {
	static long n, m;
	static BigInteger p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger sum = new BigInteger("2");
		BigInteger a = new BigInteger("1");
		BigInteger b = new BigInteger("1");
		BigInteger c = new BigInteger("0");
		BigInteger mod = new BigInteger("0");
		n = sc.nextLong();
		m = sc.nextLong();
		p = sc.nextBigInteger();
		if (m == 1) {
			mod = BigInteger.valueOf(1);
		}
		if (m == 2) {
			mod = BigInteger.valueOf(2);
		}
		for (long i = 3; i <= Math.max(m, n); i++) {
			if (i == m) {
				mod = a.add(b);
			}
			c = a.add(b);
			a = b;
			a = a.mod(p);
			b = c;
			b = b.mod(p);
			if (i <= n) {
				sum = sum.add(b).mod(p);
			}
		}
		sum = sum.mod(mod).mod(p);
		System.out.println(sum);
		sc.close();
	}
}
