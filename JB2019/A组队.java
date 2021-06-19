package JB2019;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class A组队 {
	public static int ans = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("A.txt"));
		int arr[][] = new int[20][6];
		boolean buf[] = new boolean[20];
		for (int i = 0; i < 20; i++) {
			String[] a = br.readLine().split(" ");
			for (int j = 0; j < 6; j++)
				arr[i][j] = Integer.parseInt(a[j]);
		}
		qpl(arr, buf, 1, 0);
		System.out.println(ans);
		br.close();
	}

	public static void qpl(int arr[][], boolean buf[], int k, int value) {
		if (k == 6) {
			ans = Math.max(ans, value);
			return;
		}
		for (int i = 0; i < 20; i++) {
			if (buf[i])
				continue;
			buf[i] = true;
			qpl(arr, buf, k + 1, value + arr[i][k]);
			// 递归完回溯
			buf[i] = false;
		}
	}
}
