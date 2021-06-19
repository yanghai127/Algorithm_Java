package 第九届JB;

public class A三角形面积 {
	public static void main(String[] args) {
		double a = Math.sqrt((6.4 - 2.3) * (6.4 - 2.3) + (3.1 - 2.5) * (3.1 - 2.5));
		double b = Math.sqrt((5.1 - 2.3) * (5.1 - 2.3) + (7.2 - 2.5) * (7.2 - 2.5));
		double c = Math.sqrt((6.4 - 5.1) * (6.4 - 5.1) + (7.2 - 3.1) * (7.2 - 3.1));
		double q = (a + b + c) / 2;
		double area = Math.sqrt(q * (q - a) * (q - b) * (q - c));
		System.out.println(area);
	}
}
