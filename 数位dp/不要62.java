package 数位dp;

import java.util.Scanner;

public class 不要62 {
	static int N = 15;
	static int[][] f = new int[N][N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l, r;
		init();
		while (true) {
			l = sc.nextInt();
			r = sc.nextInt();
			if (l != 0 && r != 0)
				System.out.println(dp(r) - dp(l - 1));
			else
				break;
		}
		sc.close();
	}

	private static int dp(int n) {
		if (n == 0)
			return 1;
		int[] nums = num(n);
		int last = 0;
		int ans = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			int x = nums[i];
			for (int j = 0; j < x; j++) {
				if (j == 4 || last == 6 && j == 2)
					continue;
				ans += f[i + 1][j];
			}
			if (x == 4 || last == 6 && x == 2)
				break;
			last = x;
			if (i == 0)
				ans++;
		}
		return ans;
	}

	private static int[] num(int n) {
		String s = new String();
		while (n != 0) {
			s += n % 10 + "";
			n /= 10;
		}
		int nums[] = new int[s.length()];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = s.charAt(i) - 48;
		}
		return nums;
	}

	private static void init() {
		// f[i,j]代表共i位，最高位j的合法牌照数
		for (int i = 0; i <= 9; i++)
			if (i != 4)
				f[1][i] = 1;
		for (int i = 2; i < N; i++)
			for (int j = 0; j <= 9; j++) {
				if (j == 4)
					continue;
				for (int k = 0; k <= 9; k++) {
					if (k == 4 || j == 6 && k == 2)
						continue;
					f[i][j] += f[i - 1][k];
				}
			}
	}
}
