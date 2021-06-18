package 蓝桥杯真题;

public class 平方序列 {
	public static void main(String[] args) {
		for (int x = 2020;; x++) {
			double y = Math.pow(x, 2) * 2 - 2019 * 2019;
			if ((int) Math.sqrt(y) == Math.sqrt(y)) {
				System.out.println((int) (x + Math.sqrt(y)));
				break;
			}
		}
	}
}
