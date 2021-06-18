package 蓝桥杯真题;

import java.util.Arrays;
import java.util.Scanner;

public class 调手表 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 1; i < n; i++) {
            if (i % k == 0) {
                arr[i] = i / k;
            } else {
                int m = arr[i - 1] + 1;
                for (int j = 1; j <= m; j++) {
                    int x = (k * j) % n;
                    if (x==i){
                        m = j;
                    }
                }
                arr[i] = m;
            }
        }
      
        Arrays.sort(arr);
        System.out.println(arr[arr.length - 1]);
        sc.close();
    }
}
