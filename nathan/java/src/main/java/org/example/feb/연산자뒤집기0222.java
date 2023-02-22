package org.example.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 연산자뒤집기0222 {

	static int MAX_ANS = -1 * Integer.MAX_VALUE;
	static int MIN_ANS = Integer.MAX_VALUE;
	static int[] nums;
	static int[] operators = new int[4];
	static List<List<Integer>> arrays = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		// init operators +, -, x, /
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}
		backtracking(new ArrayList<>());
		operate();
		System.out.println(MAX_ANS);
		System.out.println(MIN_ANS);
	}

	public static void operate() {
		int tmp, operator;
		for (List<Integer> arr : arrays) {
			tmp = nums[0];
			for (int i = 0; i < nums.length - 1; i++) {
				operator = arr.get(i);
				if (operator == 0) {
					tmp += nums[i+1];
				} else if (operator == 1) {
					tmp -= nums[i + 1];
				} else if (operator == 2) {
					tmp *= nums[i + 1];
				} else {
					tmp /= nums[i + 1];
				}
			}
			MAX_ANS = Math.max(MAX_ANS, tmp);
			MIN_ANS = Math.min(MIN_ANS, tmp);
		}
	}
	public static void backtracking(List<Integer> arr) {
		if (arr.size() == nums.length - 1) {
			arrays.add(arr);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operators[i] > 0) {
				operators[i]--;
				List<Integer> tmp = new ArrayList<>(arr);
				tmp.add(i);
				backtracking(tmp);
				operators[i]++;
			}
		}
	}

}
