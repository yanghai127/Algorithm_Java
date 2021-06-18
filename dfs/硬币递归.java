package dfs;

public class 硬币递归 {

	public static void main(String[] args) {
		for (int money = 0; money <= 100; money++) {
			int sum = f(money, new int[] { 1, 5, 10, 25 }, 3);
			System.out.println(money + "--" + sum);
		}
	}

	// index代表数组的下标
	private static int f(int money, int[] arr, int index) {
		// 当index=0时，剩下的只能用1元补齐，return 1
		if (index == 0)
			return 1;
		int sum = 0;
		for (int num = 0; num * arr[index] <= money; num++) {
			int shengyu = money - num * arr[index];
			sum += f(shengyu, arr, index - 1);
		}
		return sum;
	}
}
