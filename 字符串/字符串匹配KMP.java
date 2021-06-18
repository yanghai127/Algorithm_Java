package 字符串;

public class 字符串匹配KMP {
	// 时间复杂度O(m+n)
	public static void main(String[] args) {
		String str1 = "bababaaabbabcbabababb";
		String str2 = "bababb";
		int index = indexOf(str1, str2);
		System.out.println(index);
	}

	static int indexOf(String str1, String str2) {
		int i = 0, j = 0;
		int[] next = next(str2); // 生成回退数组
		while (i < str1.length()) {
			// 注意逻辑或两个条件的先后顺序，否则会有下标越界异常
			if (j == -1 || str1.charAt(i) == str2.charAt(j)) {
				i++;
				j++;
			} else
				j = next[j];
			if (j == str2.length())
				return i - j;
		}
		return -1;
	}

	private static int[] next(String str2) {
		int[] next = new int[str2.length()];
		next[0] = -1;
		int slen=str2.length();
		for (int i = 1, j = -1; i < slen-1;i++) {
			while (j != -1 && str2.charAt(i) != str2.charAt(j + 1))
				j = next[j]; // 回退
			if (str2.charAt(i) == str2.charAt(j + 1))
				j += 1;
			next[i+1] = j + 1;
		}
		return next;
	}
}
