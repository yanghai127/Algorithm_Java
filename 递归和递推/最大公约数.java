package 递归和递推;

public class 最大公约数 {
	static int f(int m, int n) {
		if (n == 0) {
			return m;
		}
		return f(n, m % n);
	}

	public static void main(String[] args) {
		System.out.println(f(43353213, 41325));
	}
}
