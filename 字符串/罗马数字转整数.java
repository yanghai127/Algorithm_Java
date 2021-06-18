package 字符串;

import java.util.Scanner;

public class 罗马数字转整数 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String s = sc.nextLine();
//		Map<Character, Integer> map = new HashMap<Character, Integer>();
//		map.put('I', 1);
//		map.put('V', 5);
//		map.put('X', 10);
//		map.put('L', 50);
//		map.put('C', 100);
//		map.put('D', 500);
//		map.put('M', 1000);
//		int sum = 0;
//		for (int i = 0; i < s.length(); i++)
//			if (i != s.length() - 1) {
//				int stmp = map.get(s.charAt(i));
//				if (stmp < map.get(s.charAt(i + 1)))
//					sum -= stmp;
//				else
//					sum += stmp;
//			} else
//				sum += map.get(s.charAt(i));
//		System.out.println(sum);
		//HashMap比switch慢太多了
		int sum=0;
		char[] str=s.toCharArray();
		for(int i=0;i<str.length;i++) 
			switch(str[i]) 
			{
				case 'I':if(i<str.length-1) if(str[i+1]=='V'||str[i+1]=='X') {sum--;break;} sum++;break;
				case 'V':{sum+=5;break;}
				case 'X':if(i<str.length-1) if(str[i+1]=='L'||str[i+1]=='C') {sum-=10;break;} sum+=10;break;
				case 'L':{sum+=50;break;}
				case 'C':if(i<str.length-1) if(str[i+1]=='D'||str[i+1]=='M') {sum-=100;break;}sum+=100;break;
				case 'D':{sum+=500;break;}
				case 'M':{sum+=1000;break;}
			}
		System.out.println(sum);
	}
}
