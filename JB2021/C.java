package JB2021;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C {
	static Set<String> ans = new HashSet<>();

	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	// String yyds！！！ 不能再错了吧？
	public static void getKB(int a, int b) {
		int x1 = a / 100, x2 = b / 100;
		int y1 = a % 100, y2 = b % 100;

		// 计算 k 的最简分数
		int up = y1 - y2, down = x1 - x2;
		int div_k = gcd(up, down);
		String K = (up / div_k) + " " + (down / div_k);

		// 特判 k 不存在，即 down = 0 的情况
		// 此时方程为 x = x1 or x2;
		if (down == 0) {
			ans.add("x = " + x1);
			return;
		}

		// 代入点 (x1, y1) 来计算 kx 和 y 的分数
		// 因为分母都是 down，所以只求分子就好
		int up_kx = up * x1, up_y = y1 * down;

		// 计算 b = y - kx 的最简分数
		int up_b = up_y - up_kx;
		int div_b = gcd(up_b, down);
		String B = (up_b / div_b) + " " + (down / div_b);

		// 加入答案
		ans.add(K + "  " + B);
	}

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		int x = 19, y = 20;
		for (int i = 0; i <= x; i++)
			for (int j = 0; j <= y; j++)
				set.add(i * 100 + j);

		List<Integer> arr = new ArrayList<>(set);
		int len = arr.size();
		// System.out.println(len);
		for (int i = 0; i < len; i++) {
			int a = arr.get(i);
			for (int j = i + 1; j < len; j++) {
				int b = arr.get(j);
				getKB(a, b);
			}
		}
		// 41300? No 40239? No 40257? Yes!
		// 好家伙，精度爆炸答案还变多了？
		System.out.println(ans.size());
	}

}
