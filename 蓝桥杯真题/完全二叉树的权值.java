package 蓝桥杯真题;

import java.util.Scanner;

public class 完全二叉树的权值 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int height = (int) (Math.log(n) / Math.log(2) + 1);
		int[] h = new int[height + 1];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			int t = (int) (Math.log(i + 1) / Math.log(2) + 1);
			h[t] += arr[i];
		}
		int max = 0;
		int maxh = 0;
		for (int i = 1; i < height + 1; i++) {
			if (h[i] > maxh) {
				max = i;
				maxh = h[i];
			}
		}
		System.out.print(max);
		sc.close();
	}
}