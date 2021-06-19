package 基础要打牢;

import java.util.Scanner;

public class 数正方形 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int block = sc.nextInt();
		int answer = 0;
		final int MOD = 1000000007;
		for (int i = 1; i < block; i++) {
			answer = (answer + i * (block - i) * (block - i)) % MOD;
		}
		System.out.println(answer);
		sc.close();
	}
}
