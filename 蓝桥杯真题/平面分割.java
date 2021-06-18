package 蓝桥杯真题;

public class 平面分割 {
	public static void main(String[] args) {

		int result = doFunction(20, 20);
		System.out.println(result);
	}

	// m个圆 n条直线
	private static int doFunction(int m, int n) {

		// 设有k个圆，当增加第k+1个圆时，最多2k个交点，故增加2k个部分，累加求和
		// 知m个圆有m(m-1)+2个部分（包含最开始的区域）

		// 第k条直线最多与原来包括原和k-1条直线的部分相交2m+k-1个交点，故增加2m+k个
		// 区域，累加求和知增加了2mn+n（n+1）/2-1个区域，注意到当k=1时增加的是2m个而不是2m+1个（因为此时
		// k-1=0）

		// 相加即为结果
		return m * (m - 1) + 1 + 2 * m * n + n * (n + 1) / 2;
	}
}
