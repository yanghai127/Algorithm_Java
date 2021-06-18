package 蓝桥杯真题;

import java.util.ArrayList;
import java.util.Scanner;

/*
* 思路:
* 1.通过lookup函数找到Alice和Bob出现的下标位置，并分别保存在nn和mm中
* 2.fanwei这个数组用于存放句子中每一个Alice的作用范围，
* 比如：有一个Alice的起始坐标为20，k为10，那么我们可以求得
* 它的有效范围是[subscript-k-3,subscript+5+k]=[7,35],
* 因此fanwei[7]++,fanwei[36]--;(从7处生效，36处失效)
* 3.定义数组shouyi，这个数组用来标记每一个位置处于多少个Alice的作用范围。
* 4.最后，遍历mm，累加每一个Bob起始下标的收益即可。
*/
public class 人物相关性分析 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		sc.nextLine();
		String sentence = sc.nextLine();
		int len = sentence.length();
		String n = "Alice";
		String m = "Bob";
		ArrayList<Integer> nn = lookup(n, " " + sentence + " ");
		ArrayList<Integer> mm = lookup(m, " " + sentence + " ");
		int[] fanwei = new int[len];
		for (int i = 0; i < nn.size(); i++) {
			int startindex = Math.max(nn.get(i) - k - 3, 0);
			int endindex = Math.min(nn.get(i) + 5 + k + 1, len - 1);
			fanwei[startindex] += 1;
			fanwei[endindex] -= 1;
		}
		int[] shouyi = new int[len];
		shouyi[0] = fanwei[0];
		for (int i = 1; i < len; i++) {
			shouyi[i] = shouyi[i - 1] + fanwei[i];
		}
		long count = 0;
		for (int j : mm)
			count += shouyi[j];
		System.out.println(count);
		sc.close();
	}

	public static ArrayList<Integer> lookup(String keywords, String sentence) {
		int index = 0;
		int keylen = keywords.length();
		char[] sen = sentence.toCharArray();
		ArrayList<Integer> nn = new ArrayList<Integer>();
		while (true) {
			int subscript = sentence.indexOf(keywords, index);
			if (subscript == -1) {
				break;
			}
			char s1 = sen[subscript + keylen];
			char s2 = sen[subscript - 1];
			if (check(s1) && check(s2)) {
				nn.add(subscript - 1);
			}
			index = subscript + keylen;
		}
		return nn;
	}

	private static boolean check(char ch) {
		if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
			return false;
		return true;
	}

}
