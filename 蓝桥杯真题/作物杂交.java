package 蓝桥杯真题;

import java.util.HashMap;
import java.util.Scanner;

public class 作物杂交 {
	static int n, m, k, t;
	static int[] Time;
	static boolean[] Had;
	static HashMap<Integer, int[]> map = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		t = sc.nextInt();
		Time = new int[n + 1];
		Had = new boolean[n + 1];
		for (int i = 1; i <= n; i++)
			Time[i] = sc.nextInt();
		for (int i = 1; i <= m; i++) {
			int index = sc.nextInt();
			Had[index] = true;
		}
		for (int i = 1; i <= k; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			map.put(c, new int[] { a, b });
		}
		System.out.println(time(t));
		sc.close();
	}

	private static int time(int index) {
		if (Had[index])
			return 0;
		Had[index] = true;
		// 得到a、b种子的时间
		int aTime = time(map.get(index)[0]);
		int bTime = time(map.get(index)[1]);
		// 从a,b得到目标种子
		int a = Time[map.get(index)[0]];
		int b = Time[map.get(index)[1]];
		// 将两者相加
		return Math.max(a, b) + Math.max(aTime, bTime);
	}
}
