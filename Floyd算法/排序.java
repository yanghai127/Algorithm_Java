package Floyd算法;

import java.util.Arrays;
import java.util.Scanner;

public class 排序 {
	static int N = 26;
	static int[][] g;
	static int[][] dist;
	static int n, m;
	static boolean[] st;

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (true) {
			n = cin.nextInt();
			m = cin.nextInt();
			if (n == 0 && m == 0)
				break;
			g = new int[N][N];
			int type = 0, t = 0; // type — 0:不确定, 1: 唯一确定, 2: 矛盾
			for (int i = 0; i < m; i++) {
				char[] temp = cin.next().toCharArray();
				if (type > 0)
					continue;

				int a = temp[0] - 'A', b = temp[2] - 'A';
				g[a][b] = 1;
				// floyd更新距离矩阵
				floyd();
				// 检查
				type = check();
				t++;
			}

			if (type == 0)
				System.out.println("Sorted sequence cannot be determined.");
			else if (type == 2)
				System.out.println("Inconsistency found after " + t + " relations.");
			else {
				System.out.println("Sorted sequence determined after " + t + " relations: " + getSequence() + ".");
			}
		}
		cin.close();
	}

	static void floyd() {
		dist = g.clone();
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dist[i][j] |= dist[i][k] & dist[k][j];
				}
			}
		}
	}

	static int check() {
		for (int i = 0; i < n; i++)
			if (dist[i][i] == 1)
				return 2;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((dist[i][j] | dist[j][i]) != 1)
					return 0;
			}
		}
		// 唯一确定，d[i][j],d[j][i]必有一个是1
		return 1;
	}
	// 简易版拓扑排序
	static String getSequence() {
		st = new boolean[N];
		Pair[] deg = new Pair[n];
		for (int i = 0; i < n; i++)
			deg[i] = new Pair((char) ('A' + i), 0);
		
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (dist[i][j] == 1)
					deg[j].d++;
				else
					deg[i].d++;
			}
		}
		
		Arrays.sort(deg, (p1, p2) -> p1.d - p2.d);
		String res = "";
		for (Pair p : deg)
			res += Character.toString(p.s);

		return res;
	}

}

class Pair {
	char s;
	int d;

	Pair(char s, int d) {
		this.s = s;
		this.d = d;
	}
}
