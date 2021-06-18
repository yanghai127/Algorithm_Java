package 蓝桥杯真题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 解释： dp[j|a[i]] 表示在所有糖果类中的 j|a[i] 类中的 最优解 
 * ① 当j=0 时 j|a[i]=a[i] dp[a[i]]=1; 
 * ② 当j=a[i1] 时 dp[[j|a[i2]] 就是 a[i1]与a[i2] 并集的 最优解 
 * ③ 进一步向上迭代 直至完全
 * ④ 当计算出j|a[i]=(1)n 时（进制全为一 ） 即包含所有种类 这个就是最终解
 */
public class 糖果 {
	static int INF = 0x3f3f3f3f;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m, k;
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		int[] dp = new int[1 << m];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			int v = 0;
			for (int j = 0; j < k; j++)
				v |= 1 << (sc.nextInt() - 1);
			for (int j = 0; j < 1 << m; j++)
				dp[j | v] = Math.min(dp[j | v], dp[j] + 1);
		}
		System.out.println(dp[(1 << m) - 1] == INF ? -1 : dp[(1 << m) - 1]);
		sc.close();
	}
}