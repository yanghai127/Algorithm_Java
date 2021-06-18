package 蓝桥杯真题;

import java.util.Scanner;

public class 后缀表达式 {
//    后缀表达式与前缀表达式在计算过程中是可以存在括号“（）”的
//    1.当-号个数为0时，所有数之和
//    2.当+号个数为0时， 全为正数，max-(min-a-b-...)所有数之和-2*最小的数
//                      全为负数，max-min-a-b-...所有数之和的相反数-2*|max|
//                      上述两种情况合并，所有数绝对值之和-2*MIN|x|
//                      有正数有负数，正数-(负数-x个正数)-y个负数，即所有数绝对值之和
//    3.当+、-号都存在时，全为正数，max-(min-a-b-...)+c+d+...，即所有数之和-2*min
//                         全为负数，max-(min+a+b+...)-c-d-...，即所有数之和的相反数-2*|max|
//                         上述两种情况合并，所有数绝对值之和-2*MIN|x|
//                         有正有负，x个正数+正数-(y个负数-x个正数)-y个负数，即所有数绝对值之和    
	public static void main(String[] args) {
		int m, n;
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		boolean x = false, y = false;// 判断正负数是否存在
		int length = m + n + 1;
		int[] a = new int[length];
		a[0] = sc.nextInt();// 第一个数
		int max = a[0];
		int min = a[0];
		if (a[0] > 0)
			x = true;
		else if (a[0] < 0)
			y = true;
		for (int i = 1; i < length; i++) {
			a[i] = sc.nextInt();
			if (min > a[i])
				min = a[i];
			if (max < a[i])
				max = a[i];
			if (a[i] > 0)
				x = true;
			else if (a[i] < 0)
				y = true;
		}
		long num = 0;
		if (n == 0) {// -号个数为0，所有数之和
			for (int i = 0; i < length; i++)
				num += a[i];
		} else if (m == 0) {// +号个数为0
			if (x && y) {// 正负数都存在
				for (int i = 0; i < length; i++)
					num += Math.abs(a[i]);
			} else if (x && !y) {// 全正数
				for (int i = 0; i < length; i++)
					num += a[i];
				num = num - 2 * min;
			} else if (!x && y) {// 全负数
				for (int i = 0; i < length; i++)
					num -= a[i];
				num = num + 2 * max;
			}
		} else {// 有+、-号
			if (x && y) {// 正负数都存在
				for (int i = 0; i < length; i++)
					num += Math.abs(a[i]);
			} else if (x && !y) {// 全正数
				for (int i = 0; i < length; i++)
					num += a[i];
				num = num - 2 * min;
			} else if (!x && y) {// 全负数
				for (int i = 0; i < length; i++)
					num -= a[i];
				num = num + 2 * max;
			}
		}
		System.out.println(num);
		sc.close();
	}

}