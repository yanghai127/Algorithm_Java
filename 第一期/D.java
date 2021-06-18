package 第一期;

public class D {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 1; i <= 2020; i++) {
			count++;
			if (i > 9) {
				count++;
			}
			if (i > 99) {
				count++;
			}
			if (i > 999) {
				count++;
			}
		}
		System.out.println(count);
	}
}
