package org.example.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 동전분배0303 {

	static List<Integer> coins = new ArrayList<>();
	static int answer;

	// 동전 c개를 선택하여 총 금액의 절반 금액을 만들어 낼 수 있다면 true 아니면 false
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
			backtracking(0, visited, totalPrice, 0);
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	static void backtracking(int sum, boolean[] visited, int totalPrice, int start) {
		if (sum >= totalPrice) {
			if (sum == totalPrice) {
				answer = 1;
			}
			return;
		}

		for (int i = start; i < coins.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				sum += coins.get(i);
				backtracking(sum, visited, totalPrice, i+1);
				sum -= coins.get(i);
				visited[i] = false;
			}
		}
	}

}
