package 第四期;

public class 身份证号码 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("11010120210221999");
		char[] s = sb.reverse().toString().toCharArray();
		long sum = 0;
		for (int i = 0; i < s.length; i++)
			sum += (Math.pow(2, i + 1) % 11 * (s[i] - 48) % 11);
		System.out.println(12 - sum % 11);
	}
}
