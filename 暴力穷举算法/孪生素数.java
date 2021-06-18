package 暴力穷举算法;

import java.util.Scanner;

public class 孪生素数 {
	static Scanner sc = new Scanner(System.in);
	static boolean arr[] = new boolean[2002];

	public static void main(String[] args) {
		int n = sc.nextInt();
		arr[1]=false;arr[2] = true;
		for (int i = 3; i <= n; i++)
			isPrime(i);
		for (int i = n; i >= 2; i--) {
			if (arr[i] && arr[i - 1]) {
				System.out.println(i + " " + (i - 1));
				break;
			}
			if (arr[i] && arr[i - 2]) {
				System.out.println(i + " " + (i - 2));
				break;
			}
		}
	}

	public static void isPrime(int n) {
		arr[n] = true;
		for (int i = 2; i < n; i++)
			if (n % i == 0) {
				arr[n] = false;
				break;
			}
	}

}
