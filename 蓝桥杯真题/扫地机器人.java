package 蓝桥杯真题;

import java.util.Arrays;
import java.util.Scanner;

public class 扫地机器人 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] location = new int[k];
		for (int i = 0; i < location.length; i++) {
			location[i] = sc.nextInt();
		}
		Arrays.sort(location);
		f(n, location);
		sc.close();
	}

	public static void f(int n, int[] a) {
		int l = 0;
		int r = n;
		int mid = (r - l) / 2;
		while (l <= r) {
			boolean flag = true;
			mid = (l + r) / 2;
//            怎么表示机器人的移动
//            每一个mid表示一个步数
//            第一台机器人怎么移动  数组中的每一个值代表机器人的初始位置，
//            每一个机器人都要遍历一遍不需要同时，一个一个来即可
			int left = 0;
			for (int i = 0; i < a.length; i++) {// i就是第几个机器人
//                用left和right指针覆盖整个地板面积n
//                需要画图
				if (a[i] - mid <= left) {
					if (a[i] <= left) {
						left = a[i] + mid - 1;
					} else
						left = left + mid;
				} else {
					flag = false;
				}

			}

			// 够了
			if (left >= n) {

			}
//                始终不够
			if (left < n) {
				flag = false;
			}

			if (flag) {
//                步长减半
				r = mid - 1;
			} else {
				l = mid + 1;
			}

		}
		System.out.println((l - 1) * 2);

	}
}