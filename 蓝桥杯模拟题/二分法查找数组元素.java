package 蓝桥杯模拟题;

import java.util.Scanner;

public class 二分法查找数组元素 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] data = new int[200];
		for (int i = 0; i < 200; i++)
			data[i] = 4 * i + 6;
		int key = sc.nextInt();
		int index = qS(data, key);
		System.out.println(index);
		sc.close();
	}

	private static int qS(int[] a, int key) {
		int low = 0, high = a.length - 1, mid;
		while (low <= high) {
			mid = (low + high) >>> 1;
			if (a[mid] == key)
				return mid;
			if (low == high)
				return -1;
			if (key >= a[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}
}
