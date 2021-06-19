package 同余;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 同余方程 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] arr = in.readLine().split(" ");
		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);

		int[] x = new int[1];
		int[] y = new int[1];
		exgcd(a, b, x, y);

		System.out.println((x[0] % b + b) % b);
	}

	static int exgcd(int a, int b, int[] x, int[] y) {
		if (b == 0) {
			x[0] = 1;
			y[0] = 0;
			return a;
		}
		int d = exgcd(b, a % b, y, x);
		y[0] -= a / b * x[0];
		return d;
	}

}
