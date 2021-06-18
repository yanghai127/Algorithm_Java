package 暴力穷举算法;

public class 第几个幸运数 {
	public static void main(String[] args) {
		long n = 59084709587505L;
		int count = 0;
		long i, j, k;
		for (i = 0; Math.pow(3, i) < n; ++i)
			for (j = 0; Math.pow(5, j) < n; ++j)
				for (k = 0; Math.pow(7, k) < n; ++k)
					if (Math.pow(3, i) * Math.pow(5, j) * Math.pow(7, k) < n)
						count++;
		// 要排除i,j,k都是0的情况，所以不用加1
		System.out.println(count);
	}
}
