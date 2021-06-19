package JB2019;

import java.util.HashSet;

public class B不同字串 {
	// 小心空串！
	public static void main(String[] args) {
		String str = "0100110001010001";
		HashSet<String> set = new HashSet<String>();
		int sl = str.length();
		for (int i = 0; i < sl; i++)
			for (int j = i + 1; j <= sl; j++)
				set.add(str.substring(i, j));
		System.out.println(set.size());
	}
}
