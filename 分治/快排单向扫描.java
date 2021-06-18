package 分治;

public class 快排单向扫描 {
	static void qS(int[] a, int left, int right) {
		if (left >= right) return;
		int i = left, j = right, pivot = a[left];
		while (i != j) {
			while (a[j] >= pivot && i < j) j --;
			if (i < j) a[i] = a[j];
			while (a[i] <= pivot && i < j) i ++;
			if (i < j) a[j] = a[i];
		}
		a[i] = pivot;
		qS(a, left, i - 1);
		qS(a, j + 1, right);
	}

	public static void main(String[] args) {
		int[] a = { 3, 4, 8, 6, 5, 9, 12, 56, 32, 11 };
		qS(a, 0, a.length - 1);
		for (int x : a)
			System.out.println(x);
	}
}
