package org.example.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타노스0221 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int totalLength = str.length();
		int zeroCnt = 0;
		int oneCnt;
		for (int i = 0; i < totalLength; i++) {
			if (str.charAt(i) == '0') {
				zeroCnt++;
			}
		}
		oneCnt = (totalLength - zeroCnt)/2;
		zeroCnt /= 2;
		String result = fingerSnap(-1, zeroCnt, // 뒤부터 0 절반 날리기
			new StringBuffer(fingerSnap(+1, oneCnt, str))		// 앞부터 1 절반 날리기
				.reverse().toString()
		);
		System.out.println(result);
	}

	private static String fingerSnap(int diff, int cnt, String str) {
		StringBuffer sb = new StringBuffer();
		int idx = 0;
		char tmp = '1';
		if (diff == -1) {
			tmp = '0';
		}

		while (cnt > 0) {
			char ch = str.charAt(idx);
			if (ch == tmp) {
				cnt--;
			} else {
				sb.append(ch);
			}
			idx++;
		}
		sb.append(str.substring(idx));
		if (diff == -1) {
			return sb.reverse().toString();
		}
		return sb.toString();
	}

}
