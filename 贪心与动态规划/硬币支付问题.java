package 贪心与动态规划;

import java.util.Scanner;

public class 硬币支付问题 {
	// 贪心算法
	static Scanner sc = new Scanner(System.in);
	static int coins[], cnts[];

	public static void main(String[] args) {
		coins = new int[] { 1, 5, 10, 50, 100, 500 };
		cnts = new int[] { 4, 4, 4, 4, 4, 4 };
		int money = sc.nextInt();
		int num = f(money, 5);
		System.out.println(num);
	}

	private static int f(int money, int index) {
		if (money <= 0) return 0; // 达到要求，后面都不用选了
		if (index == 0) return money; // 剩下的都用1块表示了
		int coinValue = coins[index];
		int x = money / coinValue;
		int cnt = cnts[index];
		int t = Math.min(x, cnt);
		return t += f(money - t * coinValue, index - 1);
	}
}
