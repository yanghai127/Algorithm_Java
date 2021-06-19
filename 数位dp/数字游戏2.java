package 数位dp;

import java.util.Scanner;

public class 数字游戏2 {
	static int P, N = 15, M = 110;
	static int[][][] f = new int[N][10][M];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int r = sc.nextInt();
		P = sc.nextInt();
		init();
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
		int[] nums = new int[s.length()];
		for (int i = 0; i < nums.length; i++)
			nums[i] = s.charAt(i) - 48;
		int last = 0;
		int ans = 0;
		// last存的是各位数字之和
		for (int i = nums.length - 1; i >= 0; i--) {
			int x = nums[i];
			for (int j = 0; j < x; j++)
				ans += f[i + 1][j][mod(-last, P)];
			last += x;
			if (i == 0 && last % P == 0)
				ans++;
		}
		return ans;
	}

	private static void init() {
		for (int i = 0; i <= 9; i++)
			f[1][i][i % P]++;
		for (int i = 2; i < N; i++)
			for (int j = 0; j <= 9; j++)
				for (int k = 0; k < P; k++)
					for (int x = 0; x <= 9; x++)
						f[i][j][k] += f[i - 1][x][mod(k - j, P)];
	}

	private static int mod(int x, int y) {
		return (x % y + y) % y;
	}
}
