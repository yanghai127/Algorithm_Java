package 第二期;

public class 第三题 {
	public static void main(String[] args) {
		int sum = 0;
		int a[] = new int[5];
		for (int i = 1; i < 7; i++) {
			a[0] = i;
			for (int j = 2; j < 8; j++) {
				a[1] = j;
				for (int j2 = 3; j2 < 9; j2++) {
					a[2] = j2;
					for (int k = 4; k < 10; k++) {
						a[3] = k;
						for (int k2 = 5; k2 < 11; k2++) {
							a[4] = k2;
							if (f(a)) {
								sum++;
							}
						}
					}
				}
			}
		}
		System.out.println(sum);
	}

	static boolean f(int a[]) {
		for (int i = 0; i < a.length - 1; i++)
			if (a[i] >= a[i + 1])
				return false;
		return true;
	}
}
