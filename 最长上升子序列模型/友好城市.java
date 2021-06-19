package 最长上升子序列模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class 友好城市 {
	// 先排序，f代表以i结尾的最长上升子序列的长度
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N = 5005, n;
	static int[] w = new int[N], f = new int[N];
	static TreeMap<Integer, Integer> map = new TreeMap<>();

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			String[] arr = in.readLine().split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			map.put(a, b);
		}

		int i = 1;
		for (int x : map.keySet())
			w[i++] = map.get(x);
		int ans = init();
		System.out.println(ans);
	}

	private static int init() {
		int max = 0;
		for (int i = 1; i <= n; i++) {
			f[i] = 1;
			for (int j = i - 1; j > 0; j--)
				if (w[i] > w[j])
					f[i] = Math.max(f[i], f[j] + 1);
			max = Math.max(max, f[i]);
		}
		return max;
	}
}
