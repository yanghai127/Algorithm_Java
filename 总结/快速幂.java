package 总结;

public class 快速幂 {
	public static void main(String[] args) {
		long good = qmi(2, 60);
		System.out.println(good);
	}
	// 利用位运算
	public static long qmi(long a, int b) { // 求 a^b
		long res = 1; // res保存结果
		while (b != 0) {
			if ((b & 1) == 1) { // 如果k的二进制数的最后一位是 1。 比如1011 & 1 = 1
				res *= a;// 可以取模， 防止结果溢出。
			}
			a *= a;// 得到 a^1, a^2, a^4, a^8, .....
			b = b >> 1; // 将b右移一位，去掉最低位。为了开始判断下一位。
		}
		return res;
	}
}
