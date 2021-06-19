package 基础要打牢;

public class 欧拉筛 {
	static final int n = 100000000;
	static boolean[] st = new boolean[n + 1];
	static int primes[] = new int[n + 1];

	public static void main(String[] args) {
		for (int i = 2; i <= n; i++) {
			if (!st[i])
				primes[++primes[0]] = i;// 将质数存到primes中
			for (int j = 1; primes[j] <= n / i; j++) {
				st[primes[j] * i] = true;
				if (i % primes[j] == 0)
					break;
			}
		}
		System.out.println(primes[0]);
	}
}
