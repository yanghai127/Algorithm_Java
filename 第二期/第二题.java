package 第二期;

public class 第二题 {
	public static void main(String[] args) {
		for (int i = 1; i < 15; i++) {
			System.out.println(Math.pow(2, i));

		}

		int a = 1;
		for (int i = 2; i < 15; i++) {
			a += i * (Math.pow(2, i) - Math.pow(2, i - 1));
		}
		a-=(16383-10000)*14;
		System.out.println(a);
	}
}
