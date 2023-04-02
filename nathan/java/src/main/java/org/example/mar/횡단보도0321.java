package org.example.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class 횡단보도0321 {

	public static void main(String[] args) throws IOException {
		횡단보도0321 m = new 횡단보도0321();
		int ans = m.solution();
		System.out.println(ans);
	}
	int N;
	int M;
	Map<Integer, Set<Point>> nodes = new HashMap<>();
	int ANS;

	class Point {
		int dest;
		int cost;

		public Point(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}
	int solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int a, b;
		for (int i = 1; i < M+1; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			keyCheck(a, b, i);
			keyCheck(b, a, i);
		}
		run();
		return ANS;
	}

	void keyCheck(int a, int b, int cost) {
		if (!nodes.containsKey(a)) {
			nodes.put(a, new HashSet<>());
		}
		nodes.get(a).add(new Point(b, cost));
	}

	void run() {
		boolean[] visited = new boolean[N+1];
		int[] dists = new int[N + 1];
		Arrays.fill(dists, Integer.MAX_VALUE);
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		q.add(new int[]{1, 0}); // [현재 위치, cost]
		dists[1] = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int point = now[0];
			int dist = now[1];
			if (!visited[point]) {
				visited[point] = true;
				for (Point next : nodes.get(point)) {
					if (next.cost + M <= dist) {
						M++;
					}
					int tmp = next.cost + M;
					if (dists[next.dest] > tmp + dist) {
						dists[next.dest] = tmp + dist;
						q.add(new int[]{next.dest, dists[next.dest]});
					}
				}
			}
		}
		ANS = dists[N];
	}

}


//4 6
//1 3
//3 2
//2 4
//2 3
//1 2
//3 4
