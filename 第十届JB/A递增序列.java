package 第十届JB;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class A递增序列 {
	// 遍历序列，每个点向8个方向扩散
	static char[][] w = new char[30][50];
	static int[] dx = new int[] { 1, 1, 0, 0, -1, -1, 1, -1 };
	static int[] dy = new int[] { -1, 1, 1, -1, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("10A.txt")); // 这个要放到前面
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 30; i++) {
			w[i] = in.readLine().toCharArray();
		}
		int cnt = 0;
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 50; j++) {
				char now = w[i][j];
				for (int k = 0; k < 8; k++) {
					for (int x = i + dx[k], y = j + dy[k]; x >= 0 && x < 30 && y >= 0
							&& y < 50; x += dx[k], y += dy[k]) {
						if (w[x][y] > now && (i < x || j < y))
							cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
