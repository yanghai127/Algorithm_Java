package dfs;

import java.math.BigInteger;
import java.util.Scanner;

public class 上楼梯 {
	// 迭代算法，时间复杂度O(n)，相比于递归算法的O(n^3)要快很多
	static Scanner in=new Scanner(System.in);
	public static void main(String[] args) {
		int n=in.nextInt();
		BigInteger sum=f(n);
		System.out.println(sum);
	}
	private static BigInteger f(int n) {
		BigInteger x0 = new BigInteger("0");
		BigInteger x1 = new BigInteger("1");
		BigInteger x2 = new BigInteger("4");
		BigInteger x3 = new BigInteger("7");
		if(n<=0) return x0;
		if(n==1) return x1;
		if(n==2) return x2;
		if(n==3) return x3;
		for (int i = 4; i <= n; i++) {
			BigInteger x_1=x1;
			x1=x2;
			x2=x3;
			x3=x_1.add(x2.add(x3));
		}
		return x3;
	}
}
