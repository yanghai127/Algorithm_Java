package 背包模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 排序接口，实现这个接口代表该类可以用Arrays.sort()进行排序
class Node implements Comparable<Node> {
	// 定义能量石属性
	int s, e, l;

	public Node(int s, int e, int l) {
		this.s = s;
		this.e = e;
		this.l = l;
	}

	// 重写排序规则，o代表下一个对象
	public int compareTo(Node o) {
		// 前小于后返回-1，当前对象排前面，前大于后返回1，当前对象排后面，相同返回0
		return Integer.compare(this.s * o.l, this.l * o.s);
	}
}

public class 能量石 {
	// 一维，不超过，最大值，01背包
	// 时间最大为N，f属性：最大能量值
	static int N = 10002;
	static Node[] a = new Node[N];
	static int[] f = new int[N];

	// 使用快速输入，时间复杂度1e9左右，还是很危险
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int cnt = 0;

		while (T-- > 0) {
			// cnt代表是第几组测试数据，n代表能量石个数，m代表最大时间
			cnt++;
			int n = Integer.parseInt(in.readLine());
			int m = 0;

			for (int i = 1; i <= n; i++) {
				String[] cur = in.readLine().split(" ");
				int s = Integer.parseInt(cur[0]);
				int e = Integer.parseInt(cur[1]);
				int l = Integer.parseInt(cur[2]);
				a[i] = new Node(s, e, l);
				m += s;
			}
			// 初始化数组
			Arrays.sort(a, 1, n + 1);
			Arrays.fill(f, -0x3f3f3f3f);
			f[0] = 0;
			// 状态计算
			for (int i = 1; i <= n; i++) {
				int s = a[i].s;
				int e = a[i].e;
				int l = a[i].l;
				for (int j = m; j >= s; j--) // j是吃完这块能量石的时间,吃的时候不损失能量,所以-s
					f[j] = Math.max(f[j], f[j - s] + e - (j - s) * l);
			}
			int res = -1;
			for (int i = 0; i <= m; i++)
				res = Math.max(res, f[i]);
			System.out.printf("Case #%d: %d\n", cnt, res);
		}
	}
}
