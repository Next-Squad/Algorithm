package org.example.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액0227_2 {

	static int ANSWER = Integer.MAX_VALUE;
	static int[] result = new int[2];


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		run(nums);
		System.out.println(result[0] + " " + result[1]);
	}

	static void run(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int now = nums[start] + nums[end];
			if (Math.abs(now) < ANSWER) {
				ANSWER = Math.abs(now);
				result[0] = nums[start];
				result[1] = nums[end];
			}
			if (now == 0) {
				break;
			} else if (now > 0) {
				end--;
			} else {
				start++;
			}
		}
	}
}
