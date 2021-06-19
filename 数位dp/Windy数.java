package 数位dp;

import java.util.Scanner;

public class Windy数 {
	static int N = 12;
	static int f[][] = new int[N][N];

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
			return 0;
		int nums[] = num(n);
		int ans = 0;
		int last = -2;
		for (int i = nums.length - 1; i >= 0; i--) {
			int x = nums[i];
			for (int j = i == nums.length - 1 ? 1 : 0; j < x; j++)
				// last存的是上一位数字的值
				if (Math.abs(j - last) >= 2)
					ans += f[i + 1][j];
			if (Math.abs(x - last) >= 2)
				last = x;
			else
				break;
			if (i == 0)
				ans++;
		}
		// 特判不足n位的数
		for (int i = 1; i < nums.length; i++)
			for (int j = 1; j <= 9; j++)
				ans += f[i][j];
		return ans;
	}

	private static int[] num(int n) {
		String s = new String();
		while (n != 0) {
			s += n % 10 + "";
			n /= 10;
		}
		int nums[] = new int[s.length()];
		for (int i = 0; i < nums.length; i++)
			nums[i] = s.charAt(i) - 48;
		return nums;
	}

	private static void init() {
		// 一共有i位且最高位为j的满足条件的个数
		for (int i = 0; i <= 9; i++)
			f[1][i] = 1;
		for (int i = 2; i < N; i++)
			for (int j = 0; j <= 9; j++)
				for (int k = 0; k <= 9; k++)
					if (Math.abs(j - k) >= 2)
						f[i][j] += f[i - 1][k];
	}
}
