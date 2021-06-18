package 蓝桥杯真题;

import java.util.Scanner;

public class 回文日期 {
	// 10^8级别小心超时
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int temp = n, count = 0;
		while (true) {
			temp++;
			char[] c = (temp + "").toCharArray();
			if (c[0] == c[7] && c[1] == c[6] && c[2] == c[5] && c[3] == c[4]) {
				count++;
				if (count == 1)
					System.out.println(temp);
				if (c[0] == c[2] && c[1] == c[3]) {
					System.out.println(temp);
					break;
				}
			}
		}
		scan.close();
	}

//	private static int[] split(int value) {
//		int array[] = new int[8];
//		for (int count = 0; value != 0; count++) {
//			array[count] = value % 10;
//			value /= 10;
//		}
//		return array;
//	}

}
