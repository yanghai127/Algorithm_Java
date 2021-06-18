package 贪心与动态规划;

import java.util.Arrays;
import java.util.Scanner;

public class 快速渡河 {
	// 贪心，时间复杂度底，但需要提前进行数学运算
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int speed[] = new int[n];
			for (int j = 0; j < n; j++) {
				speed[j] = sc.nextInt();
			}
			Arrays.sort(speed);
			f(n, speed);
		}
	}

	private static void f(int n, int[] speed) {
		int left = n;
		int ans = 0;
		while (left > 0) {
			if (left == 1) {
				ans += speed[0];
				break;
			}
			if (left == 2) {
				ans += speed[1];
				break;
			}
			if (left == 3) {
				ans += speed[2] + speed[0] + speed[1];
				break;
			}
			int s1 = speed[1] + speed[0] + speed[left - 1] + speed[1];
			int s2 = speed[left - 1] + speed[left - 2] + 2 * speed[0];
			ans += Math.min(s1, s2);
			left -= 2;
		}
		System.out.println(ans);
	}
}
