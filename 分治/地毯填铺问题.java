package 分治;

import java.util.Scanner;

public class 地毯填铺问题 {
	static Scanner sc = new Scanner(System.in);

	static void dfs(int t, int sx, int sy, int x, int y) {
		// 典型分治思想
		// sx，sy代表此正方形左上角位置，xy表示公主所在位置（或被占掉的位置）
		if (t == 0)
			return;
		int t1 = (1 << t - 1);// 小正方形边长
		if (x < sx + t1 && y < sy + t1)// 左上角
		{
			System.out.println((sx + t1) + " " + (sy + t1) + " " + 1);
			dfs(t - 1, sx, sy, x, y);//左上
			dfs(t - 1, sx, sy + t1, sx + t1 - 1, sy + t1);//右上
			dfs(t - 1, sx + t1, sy, sx + t1, sy + t1 - 1);//左下
			dfs(t - 1, sx + t1, sy + t1, sx + t1, sy + t1);//右下
		} else if (x < sx + t1)// 右上角
		{
			System.out.println((sx + t1) + " " + (sy + t1 - 1) + " " + 2);
			dfs(t - 1, sx, sy, sx + t1 - 1, sy + t1 - 1);
			dfs(t - 1, sx, sy + t1, x, y);
			dfs(t - 1, sx + t1, sy, sx + t1, sy + t1 - 1);
			dfs(t - 1, sx + t1, sy + t1, sx + t1, sy + t1);
		} else if (y < sy + t1)// 左下角
		{
			System.out.println((sx + t1 - 1) + " " + (sy + t1) + " " + 3);
			dfs(t - 1, sx, sy, sx + t1 - 1, sy + t1 - 1);
			dfs(t - 1, sx, sy + t1, sx + t1 - 1, sy + t1);
			dfs(t - 1, sx + t1, sy, x, y);
			dfs(t - 1, sx + t1, sy + t1, sx + t1, sy + t1);
		} else// 右下角
		{
			System.out.println((sx + t1 - 1) + " " + (sy + t1 - 1) + " " + 4);
			dfs(t - 1, sx, sy, sx + t1 - 1, sy + t1 - 1);
			dfs(t - 1, sx, sy + t1, sx + t1 - 1, sy + t1);
			dfs(t - 1, sx + t1, sy, sx + t1, sy + t1 - 1);
			dfs(t - 1, sx + t1, sy + t1, x, y);
		}
	}

	public static void main(String[] args) {
		dfs(sc.nextInt(), 1, 1, sc.nextInt(), sc.nextInt());
	}
}
