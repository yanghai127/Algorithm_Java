package 字符串;

public class 题目1 {
	public static void main(String[] args) {
		String str="ahdgkab";
		char arr[]=str.toCharArray();
		boolean sums[]=new boolean [130];
		for (int i = 0; i < arr.length; i++) {
			if(sums[arr[i]]) {
				System.out.println(arr[i]);
				break;
			}
			sums[arr[i]]=true;
		}
		System.out.println(new StringBuffer(str).reverse().toString());
	}
}
