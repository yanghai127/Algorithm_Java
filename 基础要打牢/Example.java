package 基础要打牢;

public class Example {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 2; i < 10000000; i++) {
			if (check(i)) {
				count++;
			}
		}
		System.out.println(count);
	}

	private static boolean check(int a) {
		for (int i = 2; i <= a / i; i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}
}
