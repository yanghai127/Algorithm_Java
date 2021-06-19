package 最小步数模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

class Node {
	String str;
	char opt;

	public Node(String str, char opt) {
		this.str = str;
		this.opt = opt;
	}
}

public class 魔板 {
	// 考察代码熟练度，熟练型手速题
	static String start, end;
	static char arr[][] = new char[2][4];
	// 开一个数组存放前面的状态，key是变换后的字符串，value是之前的字符串和操作数
	static HashMap<String, Node> map = new HashMap<>();
	// set get 函数不错
	static void set(String str) {
		int index = 0;
		for (int i = 0; i < 4; i++)
			arr[0][i] = str.charAt(index++);
		for (int i = 3; i >= 0; i--)
			arr[1][i] = str.charAt(index++);
	}

	static String get() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++)
			sb.append(arr[0][i]);
		for (int i = 3; i >= 0; i--)
			sb.append(arr[1][i]);
		return sb.toString();
	}
	
	// 交换两个字符的位置
	static void swap(int x0, int y0, int x1, int y1) {
		char temp = arr[x0][y0];
		arr[x0][y0] = arr[x1][y1];
		arr[x1][y1] = temp;
	}

	// 交换上下两行
	static String methodA(String str) {
		set(str);
		for (int i = 0; i < 4; i++)
			swap(0, i, 1, i);
		return get();
	}

	// 将最右边的一列插入到最左边；
	static String methodB(String str) {
		set(str);
		char up = arr[0][3], down = arr[1][3];
		for (int i = 3; i > 0; i--) {
			arr[0][i] = arr[0][i - 1];
			arr[1][i] = arr[1][i - 1];
		}
		arr[0][0] = up;
		arr[1][0] = down;
		return get();
	}

	// 魔板中央对的4个数作顺时针旋转。
	static String methodC(String str) {
		set(str);
		char temp = arr[0][1];
		arr[0][1] = arr[1][1];
		arr[1][1] = arr[1][2];
		arr[1][2] = arr[0][2];
		arr[0][2] = temp;
		return get();
	}

	static void bfs(String start, String end) {
		// 创建列表，自己写队列也行
		LinkedList<String> q = new LinkedList<>();
		q.addFirst(start);	// 在开头插入
		while (!q.isEmpty()) {
			String pre = q.pollLast(); // peekLast是仅检索最后一个结点
			if (pre == end)
				return;
			for (char i = 'A'; i <= 'C'; i++) {
				String str = "";
				if (i == 'A')
					str = methodA(pre);
				else if (i == 'B')
					str = methodB(pre);
				else
					str = methodC(pre);
				// 最短路要求的是第一次访问到
				if (map.containsKey(str))
					continue;

				map.put(str, new Node(pre, i));
				q.addFirst(str);
			}
		}

	}

	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		start = "12345678";
		String[] arr = in.readLine().split(" ");
		end = "";
		for (int i = 0; i < 8; i++)
			end += arr[i];

		if (end.equals(start))
			System.out.print(0);
		else {
			bfs(start, end);
			String cur = end;
			StringBuffer sb = new StringBuffer();
			int cnt = 0;
			while (true) {
				Node pre = map.get(cur);
				sb.append(pre.opt);
				cur = pre.str;
				cnt++;
				if (cur == start)
					break;
			}
			System.out.println(cnt + "\n" + sb.reverse().toString());
		}
	}
}
