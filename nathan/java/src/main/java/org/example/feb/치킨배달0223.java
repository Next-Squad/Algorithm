package org.example.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달0223 {

	static int n;
	static int m;
	static List<int[]> homes = new ArrayList<>();
	static List<int[]> chickens = new ArrayList<>();
	static List<List<int[]>> results = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] matrix = new int[n][n];
		int tmp;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1) {
					homes.add(new int[]{i, j});
				} else if (tmp == 2) {
					chickens.add(new int[]{i, j});
				}
				matrix[i][j] = tmp;
			}
		}

		int ans = Integer.MAX_VALUE;
		dfs(new ArrayList<>(), 0, new boolean[chickens.size()]);

		for (List<int[]> arr : results) {
			int[] dists = new int[homes.size()];
			Arrays.fill(dists, Integer.MAX_VALUE);
			for (int i = 0; i < homes.size(); i++) {
				for (int[] chicken : arr) {
					dists[i] = Math.min(dists[i], getDist(homes.get(i), chicken));
				}
			}
			ans = Math.min(Arrays.stream(dists).sum(), ans);
		}
		System.out.println(ans);
	}

	private static int getDist(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}

	private static void dfs(List<int[]> arr, int start, boolean[] visited) {
		if (arr.size() == m) {
			results.add(arr);
			return;
		}

		for (int i = start; i < chickens.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				List<int[]> tmp = new ArrayList<>(arr);
				tmp.add(chickens.get(i));
				dfs(tmp, i + 1, visited);
				visited[i] = false;
			}
		}
	}
}
