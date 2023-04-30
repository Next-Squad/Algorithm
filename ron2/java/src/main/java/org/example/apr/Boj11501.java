package org.example.apr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] costs;
        while(n-- > 0) {
            int t = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            costs = new int[t];
            for (int i = 0; i < t; i++) {
               costs[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(solution(t, costs));
        }

    }

    private static long solution(int t, int[] costs) {
        long answer = 0;
        int currentMax = 0;
        for (int i = t-1; i >= 0; i--) {
            if(costs[i] > currentMax) {
                currentMax = costs[i];
            } else {
                answer += currentMax - costs[i];
            }
        }
        return answer;
    }
}
