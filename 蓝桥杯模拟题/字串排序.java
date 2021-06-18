package 蓝桥杯模拟题;

import java.util.Scanner;

public class 字串排序 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		long i = (int) Math.sqrt(n * 2);
		for (; i * (i - 1) / 2 < n; i++) {
		}
		long cha = i * (i - 1) / 2 - n;
		for (long j = i - cha; j > cha; j--) {
			sb.append((char) ('a' + j - 1));
		}
		for (long j = cha; j >= 1; j--) {
			sb.append((char) ('a' + j - 1));
			sb.append((char) ('a' + j - 1));
		}
		System.out.println(sb);
		sc.close();
	}
}
