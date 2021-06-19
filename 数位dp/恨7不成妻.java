package 数位dp;

import java.util.*;

public class 恨7不成妻 {
	static class F {
		int s0, s1, s2;

		F(int a, int b, int c) {
			s0 = a;
			s1 = b;
			s2 = c;
		}
	}

	private static int N = 19, P = (int) 1e9 + 7;
	private static F[][][][] f;
	private static long[] power10;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		init();
		while (t-- > 0) {
			long l = sc.nextLong();
			long r = sc.nextLong();
			System.out.println(mod(dp(r) - dp(l - 1), P));
		}
		sc.close();
	}

	private static int mod(long x, int y) {
		return (int) (x % y + y) % y;
	}

	private static void init() {
		power10 = new long[N];
		power10[0] = 1;
		for (int i = 1; i < N; i++)
			power10[i] = power10[i - 1] * 10;

		f = new F[N][10][7][7];
		for (int i = 0; i < N; i++)
			for (int j = 0; j <= 9; j++)
				for (int a = 0; a < 7; a++)
					for (int b = 0; b < 7; b++)
						f[i][j][a][b] = new F(0, 0, 0);
		
		for (int j = 0; j <= 9; j++) {
			if (j == 7)
				continue;
			F v = f[1][j][j % 7][j % 7];
			v.s0 += 1;
			v.s1 += j;
			v.s2 += j * j;
			f[1][j][j % 7][j % 7] = v;
		}
		
		for (int i = 2; i < N; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j == 7)
					continue;
				for (int a = 0; a < 7; a++) {
					for (int b = 0; b < 7; b++) {
						for (int k = 0; k <= 9; k++) {
							if (k == 7)
								continue;
							F v1 = f[i][j][a][b];
							F v2 = f[i - 1][k][mod(a - j * (power10[i - 1] % 7), 7)][mod(b - j, 7)];
							v1.s0 = mod(v1.s0 + v2.s0, P);
							v1.s1 = mod(v1.s1 + j * (power10[i - 1] % P) % P * v2.s0 + v2.s1, P);
							v1.s2 = mod(v1.s2 + j * j * (power10[i - 1] % P) % P * (power10[i - 1] % P) % P * v2.s0
									+ 2 * j * (power10[i - 1] % P) % P * v2.s1 + v2.s2, P);
							f[i][j][a][b] = v1;
						}
					}
				}
			}
		}
	}

	private static F get(int i, int j, int a, int b) {
		int s0 = 0, s1 = 0, s2 = 0;
		for (int x = 0; x < 7; x++)
			for (int y = 0; y < 7; y++)
				if (x != a && y != b) {
					F v = f[i][j][x][y];
					s0 = (s0 + v.s0) % P;
					s1 = (s1 + v.s1) % P;
					s2 = (s2 + v.s2) % P;
				}
		return new F(s0, s1, s2);
	}

	private static int dp(long n) {
		if (n == 0)
			return 0;
		int[] nums = num(n);
		int ans = 0;
		long last_a = 0, last_b = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			int x = nums[i];
			for (int j = 0; j < x; j++) {
				if (j == 7)
					continue;
				int a = mod(-last_a * (power10[i + 1] % 7), 7);
				int b = mod(-last_b, 7);
				F v = get(i + 1, j, a, b);
				ans = mod(ans
						+ (last_a % P) * (last_a % P) % P * (power10[i + 1] % P) % P * (power10[i + 1] % P) % P * v.s0
						+ 2 * (last_a % P) * (power10[i + 1] % P) % P * v.s1 + v.s2, P);
			}
			if (x == 7)
				break;
			last_a = last_a * 10 + x;
			last_b = last_b + x;
			if (i == 0 && last_a % 7 != 0 && last_b % 7 != 0) {
				ans = mod(ans + (n % P) * (n % P) % P, P);
			}
		}
		return ans;
	}

	private static int[] num(long n) {
		String s = new String();
		while (n != 0) {
			s += n % 10 + "";
			n /= 10;
		}
		int nums[] = new int[s.length()];
		for (int i = 0; i < s.length(); i++)
			nums[i] = s.charAt(i) - 48;
		return nums;
	}
}
