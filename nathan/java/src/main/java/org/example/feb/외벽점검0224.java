package org.example.feb;

import java.util.ArrayList;
import java.util.List;

public class 외벽점검0224 {

	public static void main(String[] args) {
		외벽점검0224 m = new 외벽점검0224();
		int result = m.solution(10, new int[]{2, 3, 5}, new int[]{2, 2});
		System.out.println(result);
	}

	int dLength;
	List<List<Integer>> results = new ArrayList<>();

	public int solution(int n, int[] weak, int[] dist) {
		int answer = Integer.MAX_VALUE;
		dLength = dist.length;
		int[] newWeak = makeNewWeak(weak, n);
		dfs(new ArrayList<>(), new boolean[dLength], dist);

		for (List<Integer> tmp : results) {
			int pre = weak[0];
			int idx = 0;
			int cnt = 0;
			boolean flag = true;
			for (int i = 1; i < weak.length; i++) {
				if (weak[i] - pre > tmp.get(idx)) {
					// 도달할 수 없을 떄
					cnt++;
					pre = weak[i];
					idx++;
					if (idx == tmp.size()) {
						flag = false;
						break;
					}
				} else {
					if (i == weak.length-1) {
						cnt++;
					}
				}
			}

			if (flag) {
				answer = Math.min(answer, cnt);
			}


			pre = newWeak[0];
			idx = 0;
			cnt = 0;
			flag = true;
			for (int i = 1; i < weak.length; i++) {
				if (newWeak[i] - pre > tmp.get(idx)) {
					// 도달할 수 없을 떄
					cnt++;
					pre = weak[i];
					idx++;
					if (idx == tmp.size()) {
						flag = false;
						break;
					}
				} else {
					if (i == weak.length-1) {
						cnt++;
					}
				}
			}
			if (flag) {
				answer = Math.min(answer, cnt);
			}
		}

		if (answer == Integer.MAX_VALUE) {
			return -1;
		}
		return answer;
	}

	int[] makeNewWeak(int[] weak, int n) {
		int weakLength = weak.length;
		int[] newWeak = new int[weakLength];
		for (int i = 1; i < weakLength; i++) {
			newWeak[i-1] = weak[i];
		}
		newWeak[weakLength-1] = n + weak[0];
		return newWeak;
	}

	void dfs(List<Integer> arr, boolean[] visited, int[] dist){
		if (arr.size() == dLength) {
			results.add(arr);
			return;
		}

		for (int i = 0; i < dLength; i++) {
			if (!visited[i]) {
				visited[i] = true;
				List<Integer> tmp = new ArrayList<>(arr);
				tmp.add(dist[i]);
				dfs(tmp, visited, dist);
				visited[i] = false;
			}
		}
	}

}
