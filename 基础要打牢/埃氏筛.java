package 基础要打牢;

import java.util.Scanner;

public class 埃氏筛 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] a = new boolean[n + 1];
		for (int i = 2; i <= n/i; i++)
			if (!a[i])
				for (int j = i*i; j<= n; j+=i)
					a[j] = true;
		
		
		int count =0;
		for (int i = 2; i <= n; i++) {
			if (!a[i]) {
				count++;
			}
		}
		System.out.println(count);
		sc.close();
	}
}
