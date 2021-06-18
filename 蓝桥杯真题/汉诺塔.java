package 蓝桥杯真题;

import java.math.BigInteger;

public class 汉诺塔 {
	public static void main(String[] args) {
		BigInteger a = new BigInteger("2");
		BigInteger b = new BigInteger("1");
		System.out.println(a.pow(64).subtract(b));
	}
}
