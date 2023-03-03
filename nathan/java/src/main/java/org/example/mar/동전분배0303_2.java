package org.example.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 동전분배0303_2 {
	static List<Integer> coins = new ArrayList<>();
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			answer = 0;
			int n = Integer.parseInt(br.readLine());
			int totalPrice = 0;
			int price, nums;
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				price = Integer.parseInt(st.nextToken());
				nums = Integer.parseInt(st.nextToken());
				for (int k = 0; k < nums; k++) {
					coins.add(price);
				}
				totalPrice += price * nums;
			}
			totalPrice /= 2;
			boolean[] visited = new boolean[coins.size()];

			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	static void dp() {

	}

}
