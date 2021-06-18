package 递归和递推;

public class 直接插入排序 {
	static int[] arr = { 2, 5, 3, 1, 9 };

	public static void main(String[] args) {
		f(1);
		for (int a : arr) {
			System.out.println(a);
		}
	}

	static void f(int k) {
		if (k == arr.length - 1)
			;
		else {
			int a = arr[k];
			for (int i = k - 1; i >= 0; i--) {
				if (a < arr[i]) {
					arr[i + 1] = arr[i];
					arr[i] = a;
				} else {
					break;
				}
			}
			f(++k);
		}
	}

}
