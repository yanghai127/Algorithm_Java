package 求欧拉函数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 求欧拉函数 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(in.readLine());
		System.out.println(phi(N));
	}

	static int phi(int x) {
		int res = x;
		for (int i = 2; i <= x; i++)
			if (x % i == 0) {
				res = res * (i - 1) / i;
				while (x % i == 0)
					x /= i;
			}
		if (x > 1)
			res = res * (x - 1) / x;

		return res;
	}
}
