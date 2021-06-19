package 数位dp;

import java.util.Arrays;
import java.util.Scanner;

public class 数字游戏 {
	// 细节多，要细心
	static int N = 15;
	static int[][] f = new int[N][N]; // f[i][j]代表一共i位，最高位为j的个数

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		init();
		int l = sc.nextInt();
		int r = sc.nextInt();
		System.out.println(dp(r) - dp(l - 1));
		sc.close();
	}

	private static int dp(int n) {
		if (n == 0)
			return 1;
		String s = new String();
		while (n != 0) {
			s += n % 10 + "";
			n /= 10;
		}
		int nums[] = new int[s.length()];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = s.charAt(i) - 48;
		}
		int ans = 0, last = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			int x = nums[i];
			// 不能等于X，因为会超
			for (int j = last; j < x; j++)
				ans += f[i + 1][j];
			if (x < last)
				break;
			last = x;
			if (i == 0)
				ans++;
		}
		return ans;
	}

	private static void init() {
		// 初始化dp数组
		Arrays.fill(f[1], 1);
		for (int i = 2; i < N; i++)
			for (int j = 9; j >= 0; j--)
				f[i][j] += f[i - 1][j] + f[i][j + 1];
	}
}
