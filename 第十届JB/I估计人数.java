package 第十届JB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class I估计人数 {
	// 匈牙利算法
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N = 402, n, m;
	static int V = 1;
	static int idx[][] = new int[22][22]; // 用来存该点是第几个结点
	static int match[] = new int[N];
	static boolean[] st = new boolean[N];
	static boolean dist[][] = new boolean[N][N];

	public static void main(String[] args) throws IOException {
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		for (int i = 0; i < n; i++) {
			char[] s = in.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (s[j] == '1') {
					idx[i][j] = V++; // 存这个位置是第几个结点
				}
			}
		}

		for (int i = 0, v; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (idx[i][j] > 0) {
					v = idx[i][j];
					if (idx[i + 1][j] > 0) // 向下走能走通
						dist[v][idx[i + 1][j]] = true;
					if (idx[i][j + 1] > 0) // 向右走能走通
						dist[v][idx[i][j + 1]] = true;
				}
			}
		}

		// 如果a和b相连、b和c相连，那么使ac也相连(Floyd)
		for (int k = 0; k < V; k++)
			for (int i = 0; i < V; i++)
				for (int j = 0; j < V; j++)
					dist[i][j] |= dist[i][k] & dist[k][j];

		// 匈牙利算法
		int cnt = 0;
		for (int i = 1; i < V; i++) {
			Arrays.fill(st, false);
			if (find(i))
				cnt++;
		}
		
		System.out.print(V - cnt - 1); // 只有这些点找不到前驱，必须是开头
	}

	static boolean find(int v) {
		for (int i = 1; i < V; i++) {
			if (dist[v][i]) { // 遍历这个点可以到达的所有点
				if (!st[i]) {
					st[i] = true; // 预定女朋友
					if (match[i] == 0 || find(match[i])) {
						match[i] = v;
						return true;
					}
				}
			}
		}
		return false;
	}
}