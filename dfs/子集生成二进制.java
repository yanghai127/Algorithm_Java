package dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class 子集生成二进制 {
	public static void main(String[] args) {
		int[] a = new int[] { 2, 1, 3 };
		Arrays.sort(a);
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>(); // 大集合
		int n = a.length;
		for (int i = 1 << n; i > 0; i--) { // 不减1就有空集合
			ArrayList<Integer> s = new ArrayList<>(); // 待存小集合
			for (int j = 0; j < n; j++) // 代表集合中的下标
				if ((i >> j & 1) == 1) // 按位与，同1为1
					s.add(a[j]);
			arr.add(s);
		}
		arr.forEach(obj -> System.out.println(obj));
	}
}
