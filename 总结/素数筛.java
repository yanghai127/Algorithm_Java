package 总结;

public class 素数筛 {
	static final int n = 20;
	static boolean[] st = new boolean[n + 1];

	// 线性时间复杂度
	public static void main(String[] args) {
		for (int i = 2; i <= n / i; i++)
			if (!st[i])
				for (int j = i * i; j <= n; j += i)
					st[j] = true;
		for (int i = 2; i < st.length; i++)
			if (!st[i])
				System.out.println(i);
	}
}
