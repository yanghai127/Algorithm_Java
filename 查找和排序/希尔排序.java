package 查找和排序;

public class 希尔排序 {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 3, 8, 9, 7, 1, 2 };
		for (int i : f(arr)) {
			System.out.println(i);
		}
	}

	static int[] f(int[] arr) {
		for (int interval = arr.length / 2; interval > 0; interval /= 2) {
			for (int i =interval; i < arr.length; i++) {
				int a = arr[i];
				int j = i - interval;
				while (j >= 0 && a < arr[j]) {
					arr[j + interval] = arr[j];
					j -= interval;
				}
				arr[j + interval] = a;
			}
		}
		return arr;
	}

}
