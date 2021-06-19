package DFS之剪枝与优化;

//可行性剪枝： 只枚举木棒长度能够整除sum的那些值
//优化搜索顺序：从大到小的方式枚举碎木
//排除等效冗余：1.按照组合的方式枚举
//              2.如果当前碎木失败了直接跳过与它相等的那些碎木
//              3.如果是木棒的第一个碎木失败了，则该木棒长度一定失败
//              4.如果是木棒的最后一个碎木失败了，则该木棒长度一定失败

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//寻找某个方案的可行解的时候dfs通常需要类型boolean
//寻找某个方案的最优解的时候dfs通常无返回类型void
//求可行解还是最优解不是宏观题目的要求，而是你定义的dfs时的具体含义，具体问题具体分析
//例如本题是求最优解，然而dfs返回的是在length长度下是否可行

public class 木棒 {

	private static int n, sum, length;
	private static int[] w;
	private static boolean[] st;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			n = Integer.parseInt(in.readLine());
			if (n == 0)
				break;

			sum = 0;
			w = new int[n];
			st = new boolean[n];
			String[] arr = in.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				w[i] = Integer.parseInt(arr[i]);
				sum += w[i];
			}

			Arrays.sort(w);
			reverse(w); // 优化搜索顺序，从大到小

			length = 1;
			while (true) {
				if (sum % length == 0 && dfs(0, 0, 0)) {
					System.out.println(length);
					break;
				} else {
					length++;
				}
			}
		}
	}

	// u表示当前拼到木棒号，l表示当前木棒的长度，s表示枚举的起点位置
	private static boolean dfs(int u, int l, int s) {
		if (u * length == sum)
			return true;
		if (l == length)
			return dfs(u + 1, 0, 0);

		for (int i = s; i < n; i++) { // 排除等效冗余1.
			if (st[i])
				continue; // 可行性剪枝
			if (l + w[i] > length)
				continue; // 可行性剪枝
			
			st[i] = true;
			if (dfs(u, l + w[i], i + 1))
				return true;
			st[i] = false;

			if (l == 0)
				return false; // 排除等效冗余3.
			if (l + w[i] == length)
				return false; // 排除等效冗余4.
			int j = i;
			while (j < n && w[j] == w[i])
				j++; // 排除等效冗余2.
			i = j - 1; // 因为后面还有i++,所以该位置为j - 1
		}
		return false;
	}

	private static void reverse(int[] w) {
		for (int i = 0; i < n / 2; i++) {
			int test = w[i];
			w[i] = w[n - 1 - i];
			w[n -1 - i] = test;
		}
	}
}
