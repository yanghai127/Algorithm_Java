package 第十届JB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G数正方形 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static final int mod = (int) 1e9 + 7;

	public static void main(String[] args) throws IOException {
		long n = Integer.parseInt(in.readLine());
		long res = 0;
		for (int i = 1; i < n; i++)
			res = (res + (((n - i) * (n - i)) % mod) * i) % mod;
		System.out.println(res);
	}
}
