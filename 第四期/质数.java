package 第四期;

public class 质数 {
	public static void main(String[] args) {
		int ans = 0;
		for (int i = 1900; i < 2021; i++)
			if (check(i))
				ans++;
		System.out.println(ans);
	}

	private static boolean check(int i) {
		for (int j = 2; j * j <= i; j++)
			if (i % j == 0)
				return false;
		return true;
	}
}
