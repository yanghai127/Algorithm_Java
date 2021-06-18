package 第三期;

public class 互质 {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 1; i < 2020; i += 2) {
			if (check(i)) {
				count++;
			}
		}
		System.out.println(count);
	}

	private static boolean check(int i) {
		int a = 2020, b = i;
		while (a % b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return b == 1 ? true : false;
	}
}
