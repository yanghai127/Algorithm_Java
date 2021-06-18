package 字符串;

import java.util.Arrays;

public class 短摘尺取法 {
	public static void main(String[] args) {
		String[] w = { "c", "b", "e", "a", "r", "b", "a", "c", "t" };
		String[] keys = { "a", "b", "c" };
		solve(w, keys);
	}

	private static void solve(String[] w, String[] keys) {
		int maxlen = 0x3f3f3f3f, begin = 0, end = 0;
		int[] keyfoud = new int[keys.length];
		for (int i = 0; i < w.length; i++) {
			Arrays.fill(keyfoud, 0);
			String word = w[i];
			int index = indexOf(word, keys);
			if (index == -1)
				continue;
			else
				keyfoud[index] = 1;

			for (int j = i + 1; j < w.length && j < i + maxlen; j++) {
				String word2 = w[j];
				int index2 = indexOf(word2, keys);
				if (index2 == -1 || keyfoud[index2] == 1)
					continue;
				else
					keyfoud[index2] = 1;
				if (sum(keyfoud) == keyfoud.length) {
					if (j - i + 1 < maxlen) {
						maxlen = j - i + 1;
						begin = i;
						end = j;
					}
					break;
				}
			}
		}

		if (maxlen != 0x3f3f3f3f)
			print(w, begin, end);
		else
			System.out.println(maxlen);
	}

	private static void print(String[] w, int begin, int end) {
		for (int i = begin; i <= end; i++)
			System.out.println(w[i]);
	}

	private static int sum(int[] keyfoud) {
		int sum = 0;
		for (int i = 0; i < keyfoud.length; i++)
			sum += keyfoud[i];
		return sum;
	}

	private static int indexOf(String word, String[] keys) {
		for (int i = 0; i < keys.length; i++)
			if (keys[i].equals(word))
				return i;
		return -1;
	}
}
