package org.example.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 행성터널0309 {
	int n;
	int answer = Integer.MAX_VALUE;
	List<Planet> xPlanets = new ArrayList<>();
	List<Planet> yPlanets = new ArrayList<>();
	List<Planet> zPlanets = new ArrayList<>();
	Queue<Dist> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

	public static void main(String[] args) throws IOException {

		행성터널0309 m = new 행성터널0309();
		int solution = m.solution();
		System.out.println(solution);
	}
	int solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] point = new int[3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				point[j] = Integer.parseInt(st.nextToken());
			}
			xPlanets.add(new Planet(point[0], point[1], point[2], i));
			yPlanets.add(new Planet(point[0], point[1], point[2], i));
			zPlanets.add(new Planet(point[0], point[1], point[2], i));
		}
		xPlanets.sort(Comparator.comparingInt(o -> o.x));
		yPlanets.sort(Comparator.comparingInt(o -> o.y));
		zPlanets.sort(Comparator.comparingInt(o -> o.z));

		for (int i = 0; i < n - 1; i++) {
			pq.add(new Dist(xPlanets.get(i).idx, xPlanets.get(i + 1).idx,
				Math.abs(xPlanets.get(i).x - xPlanets.get(i + 1).x)));
			pq.add(new Dist(yPlanets.get(i).idx, yPlanets.get(i + 1).idx,
				Math.abs(yPlanets.get(i).y - yPlanets.get(i + 1).y)));
			pq.add(new Dist(zPlanets.get(i).idx, zPlanets.get(i + 1).idx,
				Math.abs(zPlanets.get(i).z - zPlanets.get(i + 1).z)));
		}
		int ans = 0;
		int[] parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
		while (!pq.isEmpty()) {
			Dist now = pq.poll();
			if (find(now.a, parents) == find(now.b, parents)) {
				continue;
			}
			union(now.a, now.b, parents);
			ans += now.val;
		}

		return ans;
	}

	private int find(int a, int[] parents) {
		if (parents[a] != a) {
			parents[a] = find(parents[a], parents);
		}
		return parents[a];
	}

	private void union(int a, int b, int[] parents) {
		if (find(a, parents) == find(b, parents)) {
			return;
		}
		if (a < b) {
			parents[find(b, parents)] = find(a, parents);
		} else {
			parents[find(a, parents)] = find(b, parents);
		}
	}

	class Planet {
		int x, y, z, idx;

		public Planet(int x, int y, int z, int idx) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.idx = idx;
		}
	}

	class Dist {
		int a;
		int b;
		int val;

		public Dist(int a, int b, int val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}
	}

}
