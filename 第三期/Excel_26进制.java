package 第三期;

public class Excel_26进制 {
	public static void main(String[] args) {
		int n = 2021;
		while (n != 0) {
			System.out.println((char) (n % 26 - 1 + 'A'));
			n /= 26;
		}
	}
}
