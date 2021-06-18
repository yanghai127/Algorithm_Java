package 暴力穷举算法;

import static java.lang.Math.*;

public class 平方十位数 {
	public static void main(String[] args) {
		long maxx = 9999999999L;
		long a = (int) floor(sqrt(maxx));
		System.out.println(a * a);
	}
}
