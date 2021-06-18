package 字符串;

public class 题目3 {
	public static void main(String[] args) {
		String str1 = "hsjddhjk";
		String str2 = new StringBuffer(str1).reverse().toString();
		if (f(str1, str2))
			System.out.println("yes");
		else
			System.out.println("no");
	}

	private static boolean f(String str1, String str2) {
		int[] arr = new int[130];
		char s1[] = str1.toCharArray();
		char s2[] = str2.toCharArray();
		for (int i = 0; i < s1.length; i++)
			arr[s1[i]]++;
		for (int i = 0; i < s2.length; i++)
			arr[s2[i]]--;
		for (int i = 0; i < arr.length; i++)
			if (arr[i] != 0)
				return false;
		return true;
	}
}
