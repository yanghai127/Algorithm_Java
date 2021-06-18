package 第三期;

import java.util.ArrayList;

public class 循环序列 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int p = 2021, v = 1160;
		list.add(v);
		while (v != 1) {
			v = p % v;
			list.add(v);
		}
		System.out.println(list.size());
	}
}
