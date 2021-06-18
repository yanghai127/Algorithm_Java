package 递归和递推;

public class 二分插入排序 {
	public static void main(String[] args) {
		// 有错误
		boolean a = false;
		int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		f(arr);
		for (int num : arr)
			System.out.println(num);
	}

	private static void f(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int left = 0, right = i - 1, key = a[i], mid = 0;
			while (left <= right) {
				mid = (right - left) / 2 + left;
				if (a[mid] == key)
					break;
				if (key >= a[mid])
					left = mid + 1;
				else
					right = mid - 1;
			}
			System.out.println(mid);
			for (int j = i; j > mid; j--)
				if (a[j - 1] > a[j])
					swap(a, j, j - 1);
				else
					break;
		}
	}

	private static void swap(int[] a, int i, int j) {
		int stmp = a[j];
		a[j] = a[i];
		a[i] = stmp;
	}
}
