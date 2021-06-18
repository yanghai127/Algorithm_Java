package dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class 部分和 {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++)
			arr[i] = in.nextInt();
		int key = in.nextInt();
		dfs(arr, key, 0, new ArrayList<Integer>());
	}

	private static void dfs(int[] a, int key, int cur, ArrayList<Integer> list) {
		if (key == 0) {
			System.out.println(list);
			return;
		}
		if (key < 0 || cur == a.length)
			return;
		dfs(a, key, cur + 1, list); // 不选
		list.add(a[cur]);
		int index = list.size() - 1; // 记录下标
		dfs(a, key - a[cur], cur + 1, list); // 选
		list.remove(index); // 回溯 
	}
}
