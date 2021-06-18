package 蓝桥杯真题;

public class 猜生日 {
	public static void main(String[] args) {
		for (int i = 19000000; i < 20000000; i++) {
			if (i % 2012 == 0 && i % 12 == 0) {
				if ((i%1000)/100==6) {
					System.out.println(i);
				}
			}
		}
	}
}
