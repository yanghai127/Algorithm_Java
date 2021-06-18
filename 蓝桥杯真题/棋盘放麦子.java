package 蓝桥杯真题;

import java.math.BigInteger;

// long类型最大为2^63-1,最小为-2^63,长度为19位,为避免溢出,最好控制在18位
public class 棋盘放麦子 {
	public static void main(String[] args) {
		BigInteger a = new BigInteger("2");
		BigInteger sum = new BigInteger("0");
		for (int i = 0; i < 64; i++) {
			sum = sum.add(a.pow(i));
		}
		System.out.println(sum);
	}
}
