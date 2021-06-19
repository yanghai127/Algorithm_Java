package 最长上升子序列模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 怪盗基德的滑翔翼 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N = 10005;
	static int[] f = new int[N];
	static int[] w = new int[N];

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int n = Integer.parseInt(in.readLine());
			String[] arr = in.readLine().split(" ");
			for (int i = 1; i <= n; i++) {
				w[i] = Integer.parseInt(arr[i - 1]);
			}

			int l = 1;
			Arrays.fill(f, 1);
			for (int i = 1; i <= n; i++) {
				for (int j = i - 1; j > 0; j--)
					if (w[i] > w[j])
						f[i] = Math.max(f[i], f[j] + 1);
				l = Math.max(l, f[i]);
			}

			int r = 1;
			for (int i = 1; i <= n; i++) {
				f[i] = 1;
				for (int j = i - 1; j > 0; j--)
					if (w[i] < w[j])
						f[i] = Math.max(f[i], f[j] + 1);
				r = Math.max(r, f[i]);
			}

			System.out.println(Math.max(l, r));
		}
	}
}
