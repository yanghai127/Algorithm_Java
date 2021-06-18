package 第二期;

public class 第五题 {
	public static void main(String[] args) {
		String str = "LANQIAO";
		char[] a = str.toCharArray();
		int sum=0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				sum+=Math.abs(a[i]-a[j]);
			}
		}
		System.out.println(sum);
	}
}
