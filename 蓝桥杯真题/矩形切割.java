package 蓝桥杯真题;

public class 矩形切割 {
	public static void main(String[] args) {
		int r = 2019, c = 324;
		int count = 1;
		while (true) {
			if (Math.max(r, c) != Math.min(r, c)) {
				if (r > c)
					r -= c;
				else
					c -= r;
				count++;
			} else {
				break;
			}
		}
		System.out.println(count);
	}
}
