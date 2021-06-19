package 欧拉函数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class RSA加密解密 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// 输入待加密英文文字
		System.out.println("请输入待加密英文文字：");
		char[] arr = in.readLine().toCharArray();
		BigInteger[] w = new BigInteger[arr.length];
		for (int i = 0; i < arr.length; i++) {
			w[i] = BigInteger.valueOf(arr[i] + 0);
//			System.out.print(w[i] + " ");
		}
//		System.out.println();
		// 公钥加密，注意N要大于127位
		System.out.println("请输入公钥e、N：");
		BigInteger e = BigInteger.valueOf(sc.nextInt());
		BigInteger N = BigInteger.valueOf(sc.nextInt());
		System.out.println("密文如下：");
		for (int i = 0; i < w.length; i++) {
			w[i] = w[i].modPow(e, N);
//			System.out.println(w[i]+" ");
			System.out.print((char) w[i].intValue());
		}
		System.out.println();
		// 私钥解密
		System.out.println("请输入私钥d：");
		BigInteger d = BigInteger.valueOf(sc.nextInt());
		System.out.println("解密明文如下：");
		for (int i = 0; i < w.length; i++) {
			System.out.print((char) w[i].modPow(d, N).intValue());
		}
	}
}
