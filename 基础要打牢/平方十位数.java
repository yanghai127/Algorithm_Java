package 基础要打牢;

public class 平方十位数 {
	/*
	 * 可以用数学思维来做，1*e+10开方为1*e+5，直接99999就是答案
	 */
	public static void main(String[] args) {
		long a=9999999999L;
		for (long i = a; i > 0; i--) {
			if (Math.sqrt(i)==Math.floor(Math.sqrt(i))) {
				System.out.println(i);
				System.out.println(Math.sqrt(i));
				break;
			}
		}
	}
}
