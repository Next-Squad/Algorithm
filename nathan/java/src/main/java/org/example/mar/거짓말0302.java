package org.example.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 거짓말0302 {
	static Set<Integer> truths = new HashSet<>();


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for (int i = 0; i < t; i++) {
			truths.add(Integer.parseInt(st.nextToken()));
		}
		List<int[]> parties = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int[] party = new int[p];
			for (int j = 0; j < p; j++) {
				party[j] = Integer.parseInt(st.nextToken());
			}
			parties.add(party);
		}
		List<int[]> tmp = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			tmp = check(parties);
		}
		System.out.println(tmp.size());
	}

	static List<int[]> check(List<int[]> parties) {
		List<int[]> arr = new ArrayList<>();
		for (int[] party : parties) {
			boolean flag = false;
			for (int p : party) {
				if (truths.contains(p)) {
					flag = true;
					break;
				}
			}
			if (flag) {
				for (int p : party) {
					truths.add(p);
				}
			} else {
				arr.add(party);
			}
		}
		return arr;
	}

}


//5 4
//1 1
//2 4 5
//2 3 4
//2 2 3
//2 1 2
