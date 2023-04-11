package org.example.apr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15649 {

	static int n, m;
	static List<List<Integer>> answer = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}

		boolean[] visited = new boolean[n];
		backtracking(new ArrayList<>(), visited);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < answer.size(); i++) {
			for (int j = 0; j < m; j++) {
				sb.append(answer.get(i).get(j))
					.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void backtracking(List<Integer> arr, boolean[] visited) {
		if (arr.size() == m) {
			answer.add(arr);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				List<Integer> tmp = new ArrayList<>(arr);
				tmp.add(i + 1);
				backtracking(tmp, visited);
				visited[i] = false;
			}
		}
	}

}
