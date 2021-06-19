package 最长上升子序列模型;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 最长上升子序列2 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	// 时间复杂度O(nlog n)，搜索dp时用了二分查找和贪心思想
	static int n, N = 100002;
	static int[] w = new int[N], f = new int[N];

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(in.readLine());
		String[] arr = in.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			w[i] = Integer.parseInt(arr[i - 1]);
		}
		int ans = init();
		System.out.println(ans);
	}

	public static int init() {
		/*
		 * 题解中最难理解的地方在于栈中序列虽然递增，但是每个元素在原串中对应的位置其实可能是乱的，那为什么这个栈还能用于计算最长子序列长度？
		 * 实际上这个栈【不用于记录最终的最长子序列】，而是【以f[i]结尾的子串长度最长为i】或者说【长度为i的递增子串中，末尾元素最小的是f[i]】。
		 * 理解了这个问题以后就知道为什么新进来的元素要不就在末尾增加，要不就替代第一个大于等于它元素的位置。
		 * 这里的【替换】就蕴含了一个贪心的思想，对于同样长度的子串，我当然希望它的末端越小越好，这样以后我也有更多机会拓展。
		 */
		int res = 0;
		for (int i = 1; i <= n; i++) {
			int l = 0, r = res;
			// 二分法
			while (l < r) {
				int mid = (l + r) >> 1;
				if (f[mid] < w[i])
					l = mid + 1;
				else
					r = mid;
			}
			f[l] = w[i];
			if (l == res)
				res++;
		}
		return res;
	}
}
