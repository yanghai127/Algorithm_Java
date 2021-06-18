package 第四期;

public class 斐波那契 {
	public static void main(String[] args) {
		int ans = 0;
		long a = 1, b = 1, c;
		for (int i = 3; i <= 100; ++i) {
			c = a + b;
			a = b;
			b = c;
			if (c % 3 == 0)
				++ans;
		}
		System.out.println(ans);
	}

}
