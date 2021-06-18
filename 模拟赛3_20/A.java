package 模拟赛3_20;

public class A {
	public static void main(String[] args) {

		for (int i = 0; i <= 20; i++) {
			for (int j = 0; j <= 33; j++) {
				int s = 100 - i - j;
				if (s % 3 == 0 && i * 5 + j * 3 + s / 3 == 100) {
					System.out.println("cock=" + i + ",hen=" + j + ",chicken=" + s);
				}
			}
		}

	}
}
