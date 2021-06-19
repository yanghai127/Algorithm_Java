package 双向BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class 字串变换 {
	// 双向广搜
	static int N = 6;
	static String[] a = new String[N]; // 代表a操作的集合
	static String[] b = new String[N]; // 代表b操作的集合
	static String st, ed;
	static int idx;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] cur = in.readLine().split(" ");
		st = cur[0];
		ed = cur[1];

		String str = "";
		while ((str = in.readLine()) != null) {
			String[] arr = str.split(" ");
			a[idx] = arr[0];
			b[idx] = arr[1];
			idx++;
		}

		int t = bfs();

		if (t > 10)
			System.out.println("NO ANSWER!");
		else
			System.out.println(t);
	}

	static int bfs() {
		LinkedList<String> qa = new LinkedList<String>();
		LinkedList<String> qb = new LinkedList<String>();
		Map<String, Integer> da = new HashMap<String, Integer>(); // 存储当达每一个点的距离
		Map<String, Integer> db = new HashMap<String, Integer>(); // 存储当达每一个点的距离

		qa.add(st);
		da.put(st, 0);
		qb.add(ed);
		db.put(ed, 0);

		while (!qa.isEmpty() && !qb.isEmpty()) {
			if (da.get(qa.peek()) + db.get(qb.peek()) + 1 > 10)
				return 11;

			int t = -1;
			if (qa.size() <= qb.size())
				t = extend(qa, da, db, a, b);
			else
				t = extend(qb, db, da, b, a);

			if (t <= 10)
				return t;
		}
		return 11;
	}

	static int extend(LinkedList<String> qa, Map<String, Integer> da, Map<String, Integer> db, String[] a, String[] b) {
		String t = qa.removeFirst();

		for (int i = 0; i < t.length(); i++) {
			for (int j = 0; j < idx; j++) {
				if (!t.startsWith(a[j], i))
					continue;
				String cur = t.substring(0, i) + b[j] + t.substring(i + a[j].length());
				if (db.containsKey(cur))
					return db.get(cur) + da.get(t) + 1;
				if (da.containsKey(cur))
					continue;
				da.put(cur, da.get(t) + 1);
				qa.add(cur);
			}
		}
		return 11;
	}
}
