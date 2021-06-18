package 总结;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class 文件读写 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt"));
		String str = new String();
		for (int i = 0; i < 1000; i++) {
			str += 'a';
		}
		bw.write(str);
		System.out.println(br.readLine());
		br.close();
		bw.close();
	}
}
