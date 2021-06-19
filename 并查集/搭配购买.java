package 并查集;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 搭配购买 {
	// 01背包加并查集
	static int N = 10005, n, m, money;
	static int[] v = new int[N], w = new int[N], f = new int[N];
	static int[] p = new int[N];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		money = Integer.parseInt(arr[2]);

		for (int i = 1; i <= n; i++) {
			arr = in.readLine().split(" ");
			v[i] = Integer.parseInt(arr[0]);
			w[i] = Integer.parseInt(arr[1]);
			p[i] = i;
		}

		for (int i = 1; i <= m; i++) {
			arr = in.readLine().split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			int pa = find(a), pb = find(b);
			if (pa != pb) {
				v[pb] += v[pa];
				w[pb] += w[pa];
				p[pa] = pb;
			}
		}

		for (int i = 1; i <= n; i++)
			if (p[i] == i) // 遍历所有祖宗节点
				for (int j = money; j >= v[i]; j--)
					f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
		
		System.out.println(f[money]);
	}

	static int find(int x) {
		if (x != p[x])
			p[x] = find(p[x]);
		return p[x];
	}
}
