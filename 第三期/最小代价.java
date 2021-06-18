package 第三期;

import java.util.Arrays;
import java.util.Scanner;

/*
5
10 A
9 BC
11 CA
4 A
5 B
 */
public class 最小代价 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[1 << 3]; // 模拟二进制，三种属性C、B、A，让它们分别代表4、2、1，即1<<2、1<<1、1<<0（注1<<n是位运算，不会的请先百度），当i==5时，dp[i]表示拥有CA属性时代价最小
		Arrays.fill(dp, 0x3f3f3f3f); // 7(十进制)==111(二进制)==CBA，故最终dp[7]就表示同时拥有ABC属性时代价最小
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			int c = sc.nextInt(), v = 0; // v是用来记录当前物品有哪几种属性
			char[] ch = sc.next().toCharArray();
			for (int j = 0; j < ch.length; j++)
				v |= 1 << (ch[j] - 'A');
			for (int j = 0; j < 1 << 3; j++) // j从1到7，分别表示A、B、C、BA、CA、CB、CBA 不会 &（与运算）和 |（或运算）滴，请先百度
				dp[v | j] = Math.min(dp[v | j], c + dp[j]);
		}
		System.out.println(dp[7] == 0x3f3f3f3f ? -1 : dp[7]);
		sc.close();
	}
}
