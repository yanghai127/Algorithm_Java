package 第十一届JB;

public class A美丽的2 {
	public static void main(String[] args) {
		int res = 0;
		for (int i = 1; i <= 2020; i++)
			if (check(i))
				res++;
		System.out.println(res);
	}

	private static boolean check(int i) {
		while (i != 0) {
			if (i % 10 == 2)
				return true;
			i /= 10;
		}
		return false;
	}
}
