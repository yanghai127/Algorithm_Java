package 蓝桥杯真题;

import java.util.Scanner;

public class 修改数组 {
	static int[] f = new int[1000002];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 1; i < f.length; i++)
			f[i] = i;
		for (int i = 0; i < n; i++) {
			a[i] = find(sc.nextInt());
			f[a[i]] = find(a[i] + 1);
		}
		for (int i : a)
			System.out.print(i + " ");
		sc.close();
	}

	public static int find(int x) {
		// 如果不是根节点，则递归寻找根节点，并将其连在根节点上
		return f[x] == x ? x : (f[x] = find(f[x]));
	}
}