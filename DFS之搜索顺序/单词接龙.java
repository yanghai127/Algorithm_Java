package DFS之搜索顺序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 单词接龙 {
	static int N = 22, n, res;
	static String[] w = new String[N];
	static int[] use = new int[N];
	static int[][] st = new int[N][N];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		for (int i = 1; i <= n; i++) {
			w[i] = in.readLine();
		}
		String h = in.readLine();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				String a = w[i], b = w[j];
				int al = a.length();
				int ml = Math.min(a.length(), b.length());
				for (int k = 1; k < ml; k++) {
					if (b.startsWith(a.substring(al - k, al))) {
						st[i][j] = k;
						break;
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			if (w[i].charAt(0) == h.charAt(0)) {
				use[i]++;
				int leng = w[i].length();
				res = Math.max(res, leng);
				bfs(i, leng);
				use[i]--;
			}
		}
		System.out.println(res);
	}

	private static void bfs(int i, int cnt) {
		for (int j = 1; j <= n; j++) {
			if (st[i][j] != 0 && use[j] < 2) {
				use[j]++;
				int leng = cnt + w[j].length() - st[i][j];
				res = Math.max(res, leng);
				bfs(j, leng);
				use[j]--;
			}
		}
	}
}
