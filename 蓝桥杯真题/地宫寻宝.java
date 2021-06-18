package 蓝桥杯真题;

import java.util.Arrays;
import java.util.Scanner;

public class 地宫寻宝 {
	public static int n, m, k;
	public static int[][] val;
	public static final int MOD = 1000000007;
	// 记忆数组，记录每一种情况
	public static long[][][][] cach = new long[50][50][14][13];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		val = new int[n][m];
		for (int i = 0; i < val.length; i++)
			for (int j = 0; j < val[i].length; j++)
				val[i][j] = sc.nextInt();
		for (int i = 0; i < cach.length; i++)
			for (int j = 0; j < cach[i].length; j++)
				for (int k = 0; k < cach[i][j].length; k++)
					Arrays.fill(cach[i][j][k], -1);
		long ans = dfs(0, 0, -1, 0);
		System.out.println(ans);
		sc.close();
	}

	public static long dfs(int x, int y, int max, int count) {
		if (x == n || y == m || count > k)
			return 0;
		if (cach[x][y][max + 1][count] != -1)
			return cach[x][y][max + 1][count];
		long ans = 0;
		if (x == n - 1 && y == m - 1) {
			if (count == k || (count + 1 == k && val[x][y] > max))
				ans = (ans + 1) % MOD;
			return ans;
		}
		int value = val[x][y];
		if (value > max) {
			ans += dfs(x + 1, y, value, count + 1);
			ans += dfs(x, y + 1, value, count + 1);
		}
		ans += dfs(x + 1, y, max, count);
		ans += dfs(x, y + 1, max, count);
		// 记录横坐标为x，纵坐标为y,值为max,拿的物品数量为cnt的情况
		cach[x][y][max + 1][count] = ans % MOD;
		return ans % MOD;
	}
}
