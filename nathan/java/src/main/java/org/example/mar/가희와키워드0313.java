package org.example.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 가희와키워드0313 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Set<String> keyWords = new HashSet<>();
		for (int i = 0; i < n; i++) {
			keyWords.add(br.readLine());
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String[] splited = br.readLine().split(",");
			for (String split : splited) {
				if (keyWords.contains(split)) {
					keyWords.remove(split);
				}
			}
			sb.append(keyWords.size()).append("\n");
		}
		System.out.println(sb);
	}
}
