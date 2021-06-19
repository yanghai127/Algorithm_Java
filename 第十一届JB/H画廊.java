package 第十一届JB;

import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H画廊 {
	// dp，属性：MIN
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N = 505, INF = 0x3f3f3f3f;
	static int L, R, d, w;
	static int[] l = new int[N], r = new int[N];
	static double[][][] f = new double[N][N][2];

	public static void main(String[] args) throws IOException {
		String[] arr = in.readLine().split(" ");
		L = Integer.parseInt(arr[0]);
		R = Integer.parseInt(arr[1]);
		d = Integer.parseInt(arr[2]);
		w = Integer.parseInt(arr[3]);
		arr = in.readLine().split(" ");
		for (int i = 1; i <= L; i++) {
			l[i] = Integer.parseInt(arr[i - 1]);
		}
		arr = in.readLine().split(" ");
		for (int i = 1; i <= R; i++) {
			r[i] = Integer.parseInt(arr[i - 1]);
		}
		// 初始化矩阵
		for (int i = 0; i <= L; i++) {
			for (int j = 0; j <= R; j++) {
				f[i][j][0] = INF;
				f[i][j][1] = INF;
			}
		}
		f[1][0][0] = hypot(w / 2.0, l[1]);
		f[0][1][1] = hypot(w / 2.0, r[1]);
		// 状态机模型，f[i][j][k]代表左边已经a了i个，右边已经a了j个，当前在k边
		for (int i = 0; i <= L; i++) {
			for (int j = 0; j <= R; j++) {
				if (i + j > 1) {
					if (i != 0)
						f[i][j][0] = min(f[i - 1][j][0] + l[i] - l[i - 1], f[i - 1][j][1] + hypot(w, l[i] - r[j]));
					if (j != 0)
						f[i][j][1] = min(f[i][j - 1][1] + r[j] - r[j - 1], f[i][j - 1][0] + hypot(w, l[i] - r[j]));
				}
			}
		}
		System.out.printf("%.2f", min(f[L][R][0] + hypot(w / 2.0, d - l[L]), f[L][R][1] + hypot(w / 2.0, d - r[R])));
	}

	private static double hypot(double v, double i) {
		return Math.sqrt(v * v + i * i);
	}
}