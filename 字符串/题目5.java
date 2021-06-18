package 字符串;

public class 题目5 {
	public static void main(String[] args) {
		String str = "aaabccddddee";
		StringBuffer s = new StringBuffer();
		char[] a = str.toCharArray();
		int num = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[i] == a[i - 1])
				num++;
			if (a[i] != a[i - 1] || i == a.length - 1) {
				s.append(a[i - 1]);
				s.append(num);
				num = 1;
			}
		}
		if (s.length() >= str.length()) {
			System.out.println(str);
		} else {
			System.out.println(s.toString());
		}
	}
}
