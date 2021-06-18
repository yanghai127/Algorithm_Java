package 暴力穷举算法;

public class 年龄问题 {
	public static void main(String[] args) {
		for (int i = 20; i < 200; i++) {
			for (int j = 20; j < 200; j++) {
				if ((i - 20) == (j - 20) * 2 && i == j * 1.5) {
					System.out.println(i + " " + j);
				}
			}
		}
	}
}
