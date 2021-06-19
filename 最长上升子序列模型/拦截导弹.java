package 最长上升子序列模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 拦截导弹 {
	// 第二问贪心算法
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int n, N = 1002;
	static int[] w = new int[N], f = new int[N];

	public static void main(String[] args) throws IOException {
		String[] arr = in.readLine().split(" ");
		n = arr.length;
		for (int i = 1; i <= n; i++) {
			w[i] = Integer.parseInt(arr[i - 1]);
		}
		int res1 = init1();
		f = new int[N];
		int res2 = init2();
		System.out.println(res1 + "\n" + res2);
	}

	private static int init2() {
		// res代表序列总数，f数组中的数一直是有序的
		int res = 0;
		for (int i = 1; i <= n; i++) {
			int j = 0;
			while (j < res && f[j] < w[i])
				j++;
			if (j == res)
				f[res++] = w[i]; // 新建一个序列
			else
				f[j] = w[i];
		}
		return res;
	}

	private static int init1() {
		// 不上升自序列
		int res = 1;
		for (int i = 1; i <= n; i++) {
			f[i] = 1;
			for (int j = i - 1; j > 0; j--)
				if (w[i] <= w[j])
					f[i] = Math.max(f[i], f[j] + 1);
			res = Math.max(res, f[i]);
		}
		return res;
	}
}
