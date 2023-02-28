package org.example.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출발지의 인덱스를 제외하고 모든 노드의 거리값을 MAX_VALUE로 설정
 * 출발지부터 하나씩 돌며, 거리 최소값 업데이트
 * 큐가 비어있게 되면 멈추고 k 거리에 해당하는 노드들을 출력
 */

public class 특정거리의도시찾기0228 {

	static List<List<Integer>> roads = new ArrayList<>();
	static int[] distances;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		init(n, x);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			roads.get(a-1).add(b-1);
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(x-1);
		while (!queue.isEmpty()) {
			int now = queue.poll();
			int dist = distances[now];
			for (int i : roads.get(now)) {
				if (distances[i] > dist + 1) {
					distances[i] = dist + 1;
					queue.add(i);
				}
			}
		}
		boolean flag = false;
		int i = 0;
		for (int dist : distances) {
			i++;
			if (dist == k) {
				flag = true;
				System.out.println(i);
			}
		}
		if (!flag) {
			System.out.println(-1);
		}
	}

	static void init(int n, int x) {
		for (int i = 0; i < n; i++) {
			roads.add(new ArrayList<>());
		}
		distances = new int[n];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[x-1] = 0;
	}

}
