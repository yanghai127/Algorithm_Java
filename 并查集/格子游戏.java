package 并查集;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 格子游戏 {
	static int N = 205, n, m;
	static int[] p = new int[N * N];

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < N * N; i++)
			p[i] = i;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);

		for (int i = 1; i <= m; i++) {
			arr = in.readLine().split(" ");
			int x = Integer.parseInt(arr[0]) - 1;
			int y = Integer.parseInt(arr[1]) - 1;
			char d = arr[2].charAt(0);

			int a = get(x, y);
			int b;
			if (d == 'D')
				b = get(x + 1, y);
			else
				b = get(x, y + 1);

			int fa = find(a), fb = find(b);
			if (fa == fb) {
				System.out.println(i);
				System.exit(0);
			}
			p[fa] = fb;
		}
		System.out.println("draw");
	}

	static int find(int x) {
		if (x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}

	static int get(int x, int y) {
		return x * n + y;
	}
}
