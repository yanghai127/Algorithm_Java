package 蓝桥杯真题;

import java.util.ArrayList;
import java.util.Arrays;

public class 质数拆分 {
	public static void main(String[] args) {
		boolean[] bs = new boolean[2020];
		Arrays.fill(bs, true);
		for (int i = 2; i * i < 2020; i++) {
			if (!bs[i])
				continue;
			for (int j = i * i; j < 2020; j += i)
				bs[j] = false;
		}
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(0);
		for (int i = 2; i < 2020; i++)
			if (bs[i])
				a.add(i);

		long[][] dp = new long[a.size()][2020];

		for (int i = 0; i < a.size(); i++) {
			dp[i][a.get(i)] = 1;
		}
		for (int i = 1; i < a.size(); i++) {
			for (int j = 0; j < 2020; j++) {
				if (j < a.get(i))
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - a.get(i)];
			}
		}
		System.out.println(dp[a.size() - 1][2019]);
	}
}