package 匈牙利算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 二分图的最大匹配 {
	// 给男同胞配女朋友算法，看最后能配多少对
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N = 505, n1, n2, m;
	static int M = 100005;
	static int[] h = new int[N], e = new int[M], ne = new int[M];
	static boolean[] st = new boolean[N]; // 预定数组
	static int[] match = new int[N]; // 存配对成功的人
	static int idx = 0;

	public static void main(String[] args) throws IOException {
		Arrays.fill(h, -1);
		String[] arr = in.readLine().split(" ");
		n1 = Integer.parseInt(arr[0]);
		n2 = Integer.parseInt(arr[1]);
		m = Integer.parseInt(arr[2]);
		for (int i = 1; i <= m; i++) {
			arr = in.readLine().split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			add(a, b); // 男a喜欢女b
		}
		// 匈牙利算法
		int res = 0;
		for (int i = 1; i <= n1; i++) { // 遍历男同胞
			Arrays.fill(st, false); // 递归用的，每次都要清空
			if (find(i)) {
				res++;
			}
		}
		
		System.out.println(res);
	}

	private static boolean find(int x) {
		for (int i = h[x]; i != -1; i = ne[i]) { // 遍历男x中意的女孩们
			int j = e[i];
			if (!st[j]) { // 在该轮模拟匹配中，这个女孩尚未被预定
				st[j] = true; // 预定该女孩
				// 如果该女孩没有男朋友，或者他男朋友能预定其它喜欢喜欢的女孩，配对成功
				if (match[j] == 0 || find(match[j])) { // 递归调用
					match[j] = x;
					return true;
				}
			}
		}
		return false;
	}

	private static void add(int a, int b) {
		e[idx] = b;
		ne[idx] = h[a];
		h[a] = idx++;
	}
}
