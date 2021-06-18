package 贪心与动态规划;

public class 钢条切割 {
	static int[] v;
	static int n;

	public static void main(String[] args) {
		n = 10;
		v = new int[] { 0, 1, 5, 8, 16, 10, 17, 17, 20, 24, 30 };
		int ans = f();
		System.out.println(ans);
	}

	private static int f() {
		int dp[] = new int[11];
		for (int i = 1; i < 11; i++)
			for (int j = 10; j > 0; j--)
				dp[j] = Math.max(dp[j], dp[j % i] + j / i * v[i]);
		return dp[10];
	}
}
