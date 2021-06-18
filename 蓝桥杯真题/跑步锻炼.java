package 蓝桥杯真题;

public class 跑步锻炼 {
	public static void main(String[] args) {

		int year, day, month;
		int week = 5;
		int sum = 0;
		for (year = 2000; year <= 2020; year++) {
			int[] a = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
				a[1] = 29;
			for (month = 0; month < 12; month++) {
				for (day = 1; day <= a[month]; day++) {
					if (day == 1 || week == 0)
						sum += 2;
					else
						sum += 1;
					week = ++week % 7;
					if (year == 2020 && month == 9 && day == 1) {
						System.out.println(sum);
						return;
					}
				}

			}
		}

	}
}