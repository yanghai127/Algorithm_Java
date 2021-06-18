package 字符串;

import java.util.Scanner;

public class 翻转单词 {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		String []s1=sc.nextLine().split(" ");
		StringBuffer s=new StringBuffer();
		for (int i = s1.length-1; i >= 0; i--)
			s.append(s1[i]+" ");
		System.out.println(s.deleteCharAt(s.length()-1).toString());
	}
}
