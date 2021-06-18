package 递归和递推;

public class 二分查找 {

	static int f(int arr[], int key) {
		if (arr == null)
			return -1;
		int left = 0, right = arr.length - 1, mid;
		while (left <= right) {
			mid = (right - left) / 2 + left;
			if (arr[mid] == key)
				return mid;
			if (arr[mid] > key)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 6, 9, 11, 16, 25, 34, 59, 102, 1111 };
		System.out.println (f(arr, 11));
	}
}
