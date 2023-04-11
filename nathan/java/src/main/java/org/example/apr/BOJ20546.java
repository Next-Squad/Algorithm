package org.example.apr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20546 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] stock = new int[14];
		int walletA = n, walletB = n;
		int stockA = 0, stockB = 0;
		int tmp;
		for (int i = 0; i < 14; i++) {
			tmp = 0;
			stock[i] = Integer.parseInt(st.nextToken());
			if (walletA >= stock[i]) {
				tmp = (walletA / stock[i]);
				stockA += tmp;
				walletA -= tmp * stock[i];
			}
		}
		int check = stock[0];
		int up = 0;
		int down = 0;
		for (int i = 1; i < 14; i++) {
			if (check > stock[i]) {
				up++;
				down = 0;
			} else if (check < stock[i]){
				up = 0;
				down++;
			} else {
				up = 0;
				down = 0;
			}
			check = stock[i];

			if (up > 2) { // 주식 전량 매수
				if (walletB >= stock[i]) {
					stockB += walletB / stock[i];
					walletB -= (walletB / stock[i]) * stock[i];
				}
			}

			if (down > 2) { // 주식 전량 매도
				walletB += stockB * stock[i];
				stockB = 0;
			}
		}
		int resultA = 0, resultB = 0;
		resultA = stock[13] * stockA + walletA;
		resultB = stock[13] * stockB + walletB;
		if (resultA == resultB) {
			System.out.println("SAMESAME");
		} else if (resultA > resultB) {
			System.out.println("BNP");
		} else {
			System.out.println("TIMING");
		}

		System.out.println(resultA +","+resultB);
//98(7), 2(1)
//96(8), 4(1)
	}

}
