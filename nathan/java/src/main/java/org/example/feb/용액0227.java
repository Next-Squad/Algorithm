package org.example.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 용액0227 {


	static List<Integer> plus = new ArrayList<>();
	static List<Integer> minus = new ArrayList<>();
	static int ANSWER = Integer.MAX_VALUE;
	static int[] result = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int tmp;
		for (int i = 0; i < n; i++) {
			tmp = Integer.parseInt(st.nextToken());
			if (tmp > 0) {
				plus.add(tmp);
			} else {
				minus.add(tmp);
			}
		}
		if (plus.size() > 1) {
			test(plus.get(0), plus.get(1));
		}

		if (minus.size() > 1) {
			test(minus.get(minus.size() - 2), minus.get(minus.size() - 1));
		}

		if (plus.size() > minus.size()) {
			run(minus, plus);
		} else {
			run(plus, minus);
		}
		Arrays.sort(result);
		System.out.println(result[0]+" "+result[1]);
	}

	private static void run(List<Integer> arr1, List<Integer> arr2) {
		for (int i : arr1) {
			test(i, arr2.get(binarySearch(i, arr2)));
		}
	}

	private static void test(int a, int b) {
		if (ANSWER > Math.abs(a+b)) {
			ANSWER = Math.abs(a+b);
			result[0] = a;
			result[1] = b;
		}
	}

	/**
	 * 1. 이진 탐색 2. 합 비교
	 */

	static int binarySearch(int target, List<Integer> arr) {
		int start = 0;
		int end = arr.size() - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			int now = arr.get(mid);
			test(now, target);
			if ((now + target) > 0) {
				end = mid - 1;
			} else if ((now + target) < 0){
				start = mid + 1;
			} else {
				return mid;
			}
		}
		if (start == -1) {
			return end;
		}
		return start;
	}
}
