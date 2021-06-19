package 第十届JB;

public class B平方拆分 {
	static int cnt = 0;

	public static void main(String[] args) {
		dfs(2019, 0);
		System.out.println(cnt);
	}

	private static void dfs(int num, int st) {
		if (num < 0)
			return;
		if (num == 0) {
			cnt++;
			return;
		}
		for (int i = st + 1, h = (int) Math.sqrt(num); i <= h; i++) {
			dfs(num - i * i, i);
		}
	}
}
