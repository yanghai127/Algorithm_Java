package 字符串;

public class rabinkarp {
	static private final int u = 10;

	// 时间复杂度O(m+n)
	public static void main(String[] args) {
		String str = "cabcabcbacabcb";
		String s = "bc";
		int len = s.length();
		int a = hash(s);
		// 注意substring函数返回的是string类型
		int stmp = hash(str.substring(0, len));
		if (a == stmp)
			System.out.println(0);
		for (int i = len; i < str.length(); i++) {
			stmp = (stmp - (int) Math.pow(u, len - 1) * str.charAt(i - len)) * u + str.charAt(i);
			if (a == stmp)
				System.out.println(i - len + 1);
		}
	}

	private static int hash(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++)
			sum = sum * u + s.charAt(i);
		return sum;
	}
}
