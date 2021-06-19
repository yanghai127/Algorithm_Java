package 第十届JB;

import java.util.HashMap;
import java.util.Map;

public class E序列求和 {
	static final int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
			89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197,
			199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317,
			331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449,
			457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541 };

	public static void main(String[] args) {
		Map<Integer, Double> map = new HashMap<>();
		long res = 0;
		map.put(1, 1.0);
		for (int i = 2; i <= 60; i++)
			resolve(i, 2, 0, i, map, new int[1024]);
		for (int i = 1; i <= 60; i++)
			res += map.get(i);
		System.out.println(res);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	static void resolve(int n, int start, int cur, int val, Map map, int[] buff) {
		if (val == 1)
			calc(n, cur, map, buff);
		else
			while (start <= val) {
				if (val % start == 0) {
					buff[cur] = start;
					resolve(n, start, cur + 1, val / start, map, buff);
				}
				start++;
			}
	}

	static void calc(int n, int cur, Map<Integer, Double> map, int[] buff) {
		double total = 1;
		int i = 0;
		while (cur-- > 0)
			total *= Math.pow(prime[i++], buff[cur] - 1);
		if (map.get(n) == null || map.get(n) > total)
			map.put(n, total);
	}
}
