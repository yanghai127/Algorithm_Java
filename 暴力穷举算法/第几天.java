package 暴力穷举算法;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 第几天 {
	public static void main(String[] args) throws ParseException {
		String end = "2021-05-04 00:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date endTime = sdf.parse(end);
		Date startTime = new Date();
//		String start =sdf.format(new Date());
//		System.out.println(start);
		int day = (int) Math.ceil((endTime.getTime() - startTime.getTime()) / (24 * 60 * 60 * 1000));
		System.out.println(day);
	}
}
