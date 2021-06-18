package 总结;

public class 七段码 {
	static int ans = 0;
	static boolean[][] map = new boolean[8][8];
	static int[] father = new int[8];

	public static void main(String[] args) {
		// 储存关系 a~g对应1~7
		map[1][2] = map[2][1] = true;// a b
		map[1][6] = map[6][1] = true;// a f
		map[2][7] = map[7][2] = true;// b g
		map[2][3] = map[3][2] = true;// b c
		map[3][4] = map[4][3] = true;// c d
		map[3][7] = map[7][3] = true;// c g
		map[4][5] = map[5][4] = true;// d e
		map[5][6] = map[6][5] = true;// e f
		map[5][7] = map[7][5] = true;// e g
		map[6][7] = map[7][6] = true;// f g
		for (int i = (1 << 7) - 1; i > 0; i--)
			fff(i);
		System.out.println(ans);
	}

	private static void fff(int n) {
		for (int i = 0; i < father.length; i++)
			father[i] = i;
		for (int i = 6; i >= 0; i--)
			if ((n >> i & 1) == 1)
				for (int j = 6; j >= 0; j--)
					if ((n >> j & 1) == 1)
						if (map[i + 1][j + 1]) {
							// 寻找根节点
							int fi = find(i + 1);
							int fj = find(j + 1);
							if (fi != fj)
								father[fi] = fj;
						}
		int temp = 0;
		for (int i = 6; i >= 0; i--)
			if ((n >> i & 1) == 1) {
				temp = find(i + 1);
				break;
			}
		for (int i = 6; i >= 0; i--)
			if ((n >> i & 1) == 1)
				if (find(i + 1) != temp)
					return;
		ans++;
	}

	private static int find(int x) {
		// 如果父节点不是自己，那么寻找父节点的根节点并将自己连在根节点上
		return father[x] == x ? x : (father[x] = find(father[x]));
	}
}
