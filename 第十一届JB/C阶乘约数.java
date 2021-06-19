package 第十一届JB;

public class C阶乘约数 {
	// 算数基本定理求约数个数
	public static void main(String[] args) {
		int[] p = new int[105]; // 储存指数
		for (int i = 2; i <= 100; i++) {
			int temp = i;
			for (int j = 2; j <= temp; j++) { // 把temp分解为多个质数相乘
				while (temp % j == 0) {
					p[j]++;
					temp /= j;
				}
			}
		}
		long sum = 1;
		for (int i = 2; i <= 100; i++) {
			if (p[i] != 0)
				sum *= p[i] + 1;
		}
		System.out.println(sum);
	}

	// 求某个数的约数个数
	static int factors(long n) {
		int res = 1, now;
		for (int i = 2; i <= n / i; i++) {
			now = i;
			while (n % i == 0) {
				now++;
				n /= i;
			}
			res *= now;
		}
		return n > 1 ? res << 1 : res;
	}
}