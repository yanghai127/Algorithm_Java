package JB2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class G外卖店优先级 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), t = sc.nextInt();
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] list = new ArrayList[t + 1];
		for (int i = 0; i <= t; i++)
			list[i] = new ArrayList<Integer>();
		for (int i = 0; i < m; i++)
			list[sc.nextInt()].add(sc.nextInt());
		boolean a[] = new boolean[n + 1];
		// key代表店铺编号，value代表优先级
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 1; i <= t; i++) {
			for (int d : map.keySet())
				if (!list[i].contains(d))
					if (map.get(d) > 1)
						map.put(d, map.get(d) - 1);
					else
						map.remove(d);
			for (int d : list[i])
				map.put(d, map.containsKey(d) ? (map.get(d) + 2) : 2);
			for (int d : map.keySet())
				if (map.get(d) > 5 || map.get(d) < 4)
					a[d] = !a[d];
		}
		int ans = 0;
		for (boolean x : a)
			if (x)
				ans++;
		System.out.println(ans);
		sc.close();
	}
}
