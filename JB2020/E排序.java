package JB2020;

public class E排序 {
	public static void main(String[] args) {
		char[] s = "jonmlkihgfedcba".toCharArray();
		int count = 0;
		for (int j = 0; j < s.length - 1; j++)
			for (int i = 0; i < s.length - j - 1; i++)
				if (s[i] > s[i + 1]) {
					char temp = s[i];
					s[i] = s[i + 1];
					s[i + 1] = temp;
					count++;
				}
		for (char c : s)
			System.out.print(c);
		System.out.println("\n" + count);
	}
}
