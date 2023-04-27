package org.example.apr;

public class Programmers_연속펄스부분수열의합 {

    public long solution(int[] sequence) {
        int size = sequence.length;

        int[] pm = new int[size];
        int[] mp = new int[size];
        int temp = 1;
        for(int i = 0; i < size; i++) {
            pm[i] = sequence[i] * temp;
            temp *= -1;
            mp[i] = sequence[i] * temp;
        }

        long[] dppm = new long[size];
        long[] dpmp = new long[size];
        dppm[0] = pm[0];
        dpmp[0] = mp[0];
        long answer = Math.max(dppm[0], dpmp[0]);
        for(int i = 1; i < size; i++) {
            dppm[i] = Math.max(pm[i], dppm[i-1] + pm[i]);
            dpmp[i] = Math.max(mp[i], dpmp[i-1] + mp[i]);

            answer = Math.max(answer, Math.max(dppm[i], dpmp[i]));
        }

        return answer;
    }
}
