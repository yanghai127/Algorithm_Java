package 蓝桥杯真题;

public class 平方和 {
	public static void main(String[] args) {
		long sum=0;
		for (int i = 1; i <= 2019; i++) {
			if (cheak(i)) {
				sum+=Math.pow(i, 2);
			}
		}
		System.out.println(sum);
	}

	private static boolean cheak(int i) {
		while (i!=0) {
			if (i%10==2||i%10==0||i%10==1||i%10==9) {
				return true;
			}
			i/=10;
		}
		return false;
	}
}
