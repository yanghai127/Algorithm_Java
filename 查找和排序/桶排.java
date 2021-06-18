package 查找和排序;

public class 桶排 {
	//天然的去重效果,最快最简单，O（n）阶
	public static void main(String[] args) {
		int a[] = { 2, 5, 6, 3, 8, 9, 4, 5, 0, 3, 3, 5, 9, 0 };
		int[] arr = new int[10];
		for (int i = 0; i < a.length; i++) {
			arr[a[i]] = 1;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1)
				System.out.println(i);
		}
	}
}
