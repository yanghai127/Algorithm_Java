package 递归和递推;

import java.util.Scanner;

public class 数组求和 {
	static Scanner sc = new Scanner(System.in);

	static int f1(int[] arr, int i) {
		if (i == arr.length - 1) {
			return arr[arr.length - 1];
		}
		return arr[i] + f1(arr, i + 1);
	}

	public static void main(String[] args) {
		int i = 0;
		int[] arr = { 0, 1, 2, 3, 4 };
		System.out.println(f1(arr, i));
	}
}
