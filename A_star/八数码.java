package A_star;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 八数码 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine().replaceAll(" ", ""); // 用""替换" "
		int count = 0;
		// 比较逆序对的数量的时候别忘了去掉x
		String tem = s.replaceAll("x", "");
		for (int i = 0; i < 8; i++)
			for (int j = i + 1; j < 8; j++)
				if (tem.charAt(i) > tem.charAt(j))
					count++;

		if ((count & 1) == 1)
			System.out.println("unsolvable");
		else
			System.out.println(bfs(s));
	}

	private static String bfs(String start) {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		char[] ch = { 'u', 'd', 'l', 'r' };
		PriorityQueue<Node> q = new PriorityQueue<>(); // 优先队列
		q.add(new Node(f(start), start));

		HashMap<String, Integer> dis = new HashMap<>();
		HashMap<String, PSC> pre = new HashMap<>();
		String end = "12345678x";
		dis.put(start, 0);
		while (!q.isEmpty()) {
			Node t = q.poll();
			String state = t.str;
			int d = dis.get(state);
			// 搜索结束
			if (state.equals(end)) {
				break;
			}
			// 获取x下标
			int x = 0;
			for (int i = 0; i < 9; i++) {
				if (state.charAt(i) == 'x') {
					x = i;
					break;
				}
			}
			for (int i = 0; i < 4; i++) {
				int fx = dx[i] + x / 3;
				int fy = dy[i] + x % 3;
				if (fx < 0 || fx >= 3 || fy < 0 || fy >= 3) {
					continue;
				}
				// 复原
				// 交换
				String neStr = swap(state, x, fx * 3 + fy);
				if (!dis.containsKey(neStr) || dis.get(neStr) > d + 1) {
					dis.put(neStr, d + 1);
					q.add(new Node(d + 1 + f(neStr), neStr));
					// 这里注意谁是键，
					pre.put(neStr, new PSC(state, ch[i]));
				}
			}
		}

		StringBuilder res = new StringBuilder();
		while (!end.equals(start)) {
			res.append(pre.get(end).c);
			end = pre.get(end).s;
		}
		return res.reverse().toString();
	}

	static String swap(String s, int i, int j) {
		if (i > j) {
			int tem = i;
			i = j;
			j = tem;
		}
		return s.substring(0, i) + s.charAt(j) + s.substring(i + 1, j) + s.charAt(i) + s.substring(j + 1, s.length());
	}

	private static int f(String s) {
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'x') {
				continue;
			}
			int a = s.charAt(i) - '1';
			// 加上曼哈顿距离
			ans += Math.abs(i / 3 - a / 3) + Math.abs(i % 3 - a % 3);
		}
		return ans;
	}
}

class PSC {
	String s;
	char c;

	public PSC(String s, char c) {
		this.s = s;
		this.c = c;
	}
}

class Node implements Comparable<Node> {
	int dis;
	String str;

	public Node(int dis, String str) {
		this.dis = dis;
		this.str = str;
	}

	public int compareTo(Node o) {
		return Integer.compare(dis, o.dis);
	}
}
