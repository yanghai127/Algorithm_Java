package 暴力穷举算法;

public class 猴子分香蕉 {
	public static void main(String[] args) {
		for (int x = 1; x < 0x3f3f3f3f; x++) {
			int n = x;
			if (n % 5 == 1) {
				n = (n - 1) / 5 * 4;
				if (n % 5 == 2) {
					n = (n - 2) / 5 * 4;
					if (n % 5 == 3) {
						n = (n - 3) / 5 * 4;
						if (n % 5 == 4) {
							n = (n - 4) / 5 * 4;
							if (n % 5 == 0 && n > 5) {
								System.out.println(x);
								break;
							}
						}
					}
				}
			}
		}
	}
}
