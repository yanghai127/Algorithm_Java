package 暴力穷举算法;

public class 哪天返回 {
	public static void main(String[] args) {
		int sum = 0, day = 1;
		for (day = 1; sum < 108; day++) {
			int money = day * 2 - 1;
			sum += money;
		}
		System.out.println(day - 1);
	}
}
