package 第十一届JB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G皮亚诺曲线距离 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		long x1, x2, y1, y2;
		int k;
		k = Integer.parseInt(in.readLine());
		if (k >= 40)
			k = 39;// k>40无效且爆long
		String[] arr = in.readLine().split(" ");
		x1 = Integer.parseInt(arr[0]);
		y1 = Integer.parseInt(arr[1]);
		arr = in.readLine().split(" ");
		x2 = Integer.parseInt(arr[0]);
		y2 = Integer.parseInt(arr[1]);
		long ans = dfs(x2, y2, k) - dfs(x1, y1, k);
		System.out.println(ans > 0 ? ans : -ans);
	}

	static long Pow(long x, int k) {
		if (k == 0)
			return 1;
		if (k == 1)
			return x;
		long ans = (long) Math.pow(x, k >> 1);
		ans *= ans;
		if ((k & 1) != 0)
			ans *= x;
		return ans;
	}

	static long dfs(long x, long y, int k) {
		if (k == 0)
			return 1;
		long tx = x, ty = y, K = Pow(3, k - 1), cx, cy, ans;
		tx /= K;
		ty /= K;
		cx = x % K;
		cy = y % K;
		long a = tx * 10 + ty;
		switch ((int) a) {
		case 0:
			ans = dfs(cx, cy, k - 1);
			return ans;
		case 1:
			ans = dfs(K - 1 - cx, cy, k - 1) + K * K;
			return ans;
		case 2:
			ans = dfs(cx, cy, k - 1) + 2 * K * K;
			return ans;
		case 10:
			ans = dfs(cx, K - 1 - cy, k - 1) + 5 * K * K;
			return ans;
		case 11:
			ans = dfs(K - 1 - cx, K - 1 - cy, k - 1) + 4 * K * K;
			return ans;
		case 12:
			ans = dfs(cx, K - 1 - cy, k - 1) + 3 * K * K;
			return ans;
		case 20:
			ans = dfs(cx, cy, k - 1) + 6 * K * K;
			return ans;
		case 21:
			ans = dfs(K - 1 - cx, cy, k - 1) + 7 * K * K;
			return ans;
		case 22:
			ans = dfs(cx, cy, k - 1) + 8 * K * K;
			return ans;
		}
		return a;
	}
}
