package dfs;

import java.util.HashSet;

public class 子集生成 {
	// 从小往大推，要搞懂原理
	static int[] a = new int[] { 1, 2, 3 };
	public static void main(String[] args) {
		HashSet<HashSet<Integer>> set = f(a.length - 1);
		HashSet<Integer> nil = new HashSet<Integer>();
		set.remove(nil);
		set.forEach(obj -> System.out.println(obj));
	}

	@SuppressWarnings("unchecked")
	private static HashSet<HashSet<Integer>> f(int n) {
		HashSet<HashSet<Integer>> newSet = new HashSet<>();
		if (n == 0) {
			HashSet<Integer> nil = new HashSet<Integer>();
			HashSet<Integer> first = new HashSet<Integer>();
			first.add(a[0]);
			newSet.add(nil);
			newSet.add(first);
			return newSet;
		}
		HashSet<HashSet<Integer>> oldSet = f(n - 1);
		for (HashSet<Integer> set : oldSet) {
			newSet.add(set);
			// 注意克隆和“ = ”的区别！对象一般都是引用
			HashSet<Integer> clone = (HashSet<Integer>) set.clone();
			clone.add(a[n]);
			newSet.add(clone);
		}
		return newSet;
	}
}
