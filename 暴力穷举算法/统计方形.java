package 暴力穷举算法;

import java.util.Scanner;

public class 统计方形 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int a = 0;
		int m = sc.nextInt();
		int n = sc.nextInt();
		long sqr = 0;
		long rec = 0;
		for (int i = 0; i < n; i++)// 循环，从n-0到n-(n-1)
			for (int j = 0; j < m; j++) {// 循环，从m-0到m-(m-1)
				if (i == j)
					sqr += (n - i) * (m - j);// 如果i==j，说明是正方形
				else
					rec += (n - i) * (m - j);// 如果不等说明是矩形
			}
		System.out.println(sqr + " " + rec);
	}
}
