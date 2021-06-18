package 递归和递推;

public class 插入排序 {
	// 和冒泡排序有点像
	public static void main(String[] args) {
		int[] arr = { 2, 5, 3, 1, 9, 8, 9, 5, 4, 6, 8, 9, 2 };
		for (int i = 1; i < arr.length; i++)
			for (int j = i-1; j >= 0; j--)
				if (arr[j] > arr[j+1])
					swap(arr, j, j+1);
				else
					break;
		for (int num : arr)
			System.out.println(num);
	}

	private static void swap(int[] a, int i, int j) {
			int stmp = a[j];
			a[j] = a[i];
			a[i] = stmp;
	}
}
