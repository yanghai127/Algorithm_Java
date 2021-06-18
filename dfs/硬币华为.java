package dfs;

import java.util.Scanner;

public class 硬币华为 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		int a[][] = new int[3][11];
		int dp[] = new int[n + 1];
		int a[] = new int[] { 1, 2, 5 };
		int sum = 0;
		sum = f(n, a, 2);
		System.out.println(sum);
//		for (int i = 0; i < 3; i++) {
//			a[i][0] = 1;
//		}
//		for (int i = 0; i < 11; i++) {
//			a[0][i] = 1;
//		}
//		for (int i = 1; i < 3; i++) {
//			for (int j = 1; j < 11; j++) {
//				if (j>=arr[i]) {
//					a[i][j] = a[i][j - arr[i]] + a[i-1][j];					
//				}else {
//					a[i][j] = a[i-1][j];
//				}
//			}
//		}
//		sum = a[2][10];
		dp[0] = 1;
		for (int i = 0; i < a.length; i++)
			for (int j = 1; j <= n; j++)
				dp[j] = j >= a[i] ? dp[j] + dp[j - a[i]] : dp[j];
		sum = dp[n];
		System.out.println(sum);
		sc.close();
	}

	private static int f(int n, int[] arr, int num) {
		if (num == 0)
			return 1;
		int sum = 0;
		for (int i = 0; i * arr[num] <= n; i++) {
			int shengyu = n - i * arr[num];
			sum += f(shengyu, arr, num - 1);
		}
		return sum;
	}
}
