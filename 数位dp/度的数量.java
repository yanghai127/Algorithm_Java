package 数位dp;

import java.util.Scanner;

/*
15 20 2 2
3
 */
public class 度的数量 {
	// 进制问题，转换为B进制
	static final int N = 35;
	static int K, B;
	// f数组用来存组合数
	static int[][] f = new int[N][N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int R = sc.nextInt();
		K = sc.nextInt();
		B = sc.nextInt();
		init();
		System.out.println(dp(R) - dp(l - 1));
		sc.close();
	}

	private static int dp(int n) {
		if (n == 0)
			return 0;
		int[] nums = num(n);
		int ans = 0;
		int last = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			int x = nums[i];
			if (x != 0) {
				ans += f[i][K - last];
				if (x > 1) {
					if (K - last - 1 >= 0)
						ans += f[i][K - last - 1];
					// x大于1后面的都不用判了，ans集合里都包含了
					break;
				} else {
					last++;
					if (last > K)
						break;
				}
			}
			if (i == 0 && last == K)
				ans++; // 最右侧分支上的答案
		}
		return ans;
	}

	private static int[] num(int n) {
		String s = new String();
		while (n != 0) {
			s += n % B + "";
			n /= B;
		}
		int nums[] = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			nums[i] = s.charAt(i) - 48;
		}
		return nums;
	}

	private static void init() {
		// 从i个数里选j个数的方案数，排列组合
		for (int i = 0; i < N; i++)
			for (int j = 0; j <= i; j++)
				if (j == 0)
					f[i][j] = 1;
				else
					f[i][j] = f[i - 1][j] + f[i - 1][j - 1];
	}
}
