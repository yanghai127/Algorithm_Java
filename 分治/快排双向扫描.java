package 分治;

public class 快排双向扫描 {
	static void qS(int[] a, int left, int right) {
		if (left >= right) return;
		int i = left, j = right, pivot = a[left];
		while (i != j) {
			while (a[j] >= pivot && i < j) j--;
			while (a[i] <= pivot && i < j) i++;
			if (i < j) swap(a, i, j);
		}
		swap(a, left, j);
		qS(a, left, j - 1);
		qS(a, j + 1, right);
	}

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 9, 8, 7, 6, 5, 0, 4, 8, 3, 2, 8, 7, 10 };
		qS(arr, 0, arr.length - 1);
		for (int num : arr)
			System.out.println(num);
	}
}
