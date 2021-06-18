package 递归和递推;

public class 斐波那契数列 {
	static int f(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		return f(n - 1) + f(n - 2);
	}

	public static void main(String[] args) {
		System.out.println(f(6));
	}
}
