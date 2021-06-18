package 蓝桥杯真题;

// LeetCode8
public class 字符串转换整数 {
	public static void main(String[] args) {
		String s = "15291283472332";
		int a = f(s);
		System.out.println(a);
	}

	private static int f(String s) {
		s = s.trim();
		int ans = 0;
		char[] c = s.toCharArray();
		int x = -1;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '+' || c[i] == '-') {
				if (x == -1 && i == 0) {
					x = i;
					continue;
				} else
					break;
			}

			if (c[i] >= '0' && c[i] <= '9') {
				if (ans > Integer.MAX_VALUE / 10 || ans * 10 > Integer.MAX_VALUE - (c[i] - 48))
					if (x != -1)
						return c[x] == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
					else
						return Integer.MAX_VALUE;
				ans = ans * 10 + c[i] - 48;
			} else
				break;
		}
		if (x != -1)
			return c[x] == '-' ? (ans * -1) : ans;
		else
			return ans;
	}
}
