package org.example.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 뒤집기0220 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char pre = str.charAt(0);
		int one = 0;
		int zero = 0;
		if (pre == '1') {
			one++;
		} else {
			zero++;
		}

		for (int i = 1; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (pre != ch) {
				if (ch == '1') {
					one++;
				} else {
					zero++;
				}
				pre = ch;
			}
		}

		System.out.print(Math.min(one, zero));
	}
}
