package 第一期;

public class E {
	public static void main(String[] args) {
		int[] a = new int[] { 87, 39, 35, 1, 99, 10, 54, 1, 46, 24, 74, 62, 49, 13, 2, 80, 24, 58, 8, 14, 83, 23, 97,
				85, 3, 2, 86, 10, 71, 15 };
		int count = 0;
		for (int i = a.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[i] < a[j]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
