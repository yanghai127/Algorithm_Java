package 字符串;

import java.util.Arrays;

public class 最短摘要尺取法 {
	public static void main(String[] args) {
		String[] w = { "a", "b", "e", "a", "c", "b", "a", "a", "t" };
		String[] keys = { "a", "b", "c" };
		solve(w, keys);
	}

	// 返回word在q数组中的下标序号，不存在就返回-1
	static int indexOf(String[] q, String word) {
		for (int i = 0; i < q.length; i++) {
			if (q[i].equals(word))
				return i;
		}
		return -1;
	}

	static void solve(String[] w, String[] keys) {
		int begin = -1;
		int end = -1;
		int p2 = -1; // 上一次囊括所有关键字的右边界
		// 定义最小长度，初始化为int的最大值2的31次方减一
		int minlen = Integer.MAX_VALUE;
		// 定义关键字数组，辅助判断是否包含所有关键字
		int[] keyfoud = new int[keys.length];
		for (int i = 0; i < w.length; i++) {
			// 将数组清零，进行新的一段字符串统计
			Arrays.fill(keyfoud, 0);
			String word = w[i];
			int index = indexOf(keys, word);
			if (-1 == index) {// 不是关键字继续先前移动
				continue;
			} else {
				keyfoud[index] = 1;// 进行标记
			}

			int j;
			// 如果不是第一次循环j等于上一次囊括所有关键字的右边界
			if (p2 != -1)
				j = p2;
			else
				j = i + 1;
			for (; j < w.length; j++) {
				String word2 = w[j];
				int index2 = indexOf(keys, word2);
				if (index2 == -1 || keyfoud[index2] == 1) {
					// 不是关键字或者已经标记过了就继续向后移动
					continue;
				} else {
					keyfoud[index2] = 1;// 标记一下
				}
				if (sum(keyfoud) == keyfoud.length) {
					// 关键字齐了
					p2 = j;
					if (j - i + 1 < minlen) {// 更新
						begin = i;
						end = j;
						minlen = end - begin + 1;
					}
					break;
				}
			}
		}
		// 打印最短摘要
		if (minlen != Integer.MAX_VALUE) {
			print(w, begin, end);
		} else {
			System.out.println("not found");
		}
	}

	private static void print(String[] w, int begin, int end) {
		for (int i = begin; i <= end; i++) {
			System.out.print(w[i] + " ");
		}
	}

	// 数组求和函数
	private static int sum(int[] keyfoud) {
		int sum = 0;
		for (int i = 0; i < keyfoud.length; i++) {
			sum += keyfoud[i];
		}
		return sum;
	}
}