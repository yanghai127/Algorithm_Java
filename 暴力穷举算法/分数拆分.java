package 暴力穷举算法;

import java.util.Scanner;

public class 分数拆分 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int k = sc.nextInt();
		for (int y = k + 1; y <= k * 2; y++) {
			for (int x = y; x < 0x3f3f3f3f; x++) {
				if (1.0 / k >= 1.0 / y + 1.0 / x) {
					if (1.0 / k == 1.0 / y + 1.0 / x)
						System.out.println("1/" + k + "=1/" + (int) x + "+1/" + y);
					break;
				}
			}
//			以下算法有精度损失
//			double x = 1.0 / (1.0 / k - 1.0 / y);
//			if (((int) x) * 1.0 == x) {
//				System.out.println("1/" + k + "=1/" + (int) x + "+1/" + y);
//			}
		}
	}
}
