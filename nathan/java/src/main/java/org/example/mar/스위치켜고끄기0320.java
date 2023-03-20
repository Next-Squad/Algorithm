package org.example.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치켜고끄기0320 {

	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N + 1];
		for (int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int loop = Integer.parseInt(br.readLine());
		for (int i = 0; i < loop; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			if (gender == 1) {
				man(k);
			} else {
				woman(k);
			}
		}

		for (int i = 1; i < N + 1; i++) {
			System.out.print(arr[i]+" ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}
	}

	static void man(int k) {
		for (int i = k; i < N + 1; i += k) {
			change(i);
		}
	}

	static void woman(int k) {
		int left = k-1;
		int right = k+1;
		change(k);
		while (left > 0 && right < N + 1) {
			if (arr[left] != arr[right]) {
				break;
			}
			change(left--);
			change(right++);
		}
	}

	static void change(int idx) {
		if (arr[idx] == 0) {
			arr[idx] = 1;
		} else {
			arr[idx] = 0;
		}
	}
}
