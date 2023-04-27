package org.example.apr;

import java.util.Arrays;

public class Programmers_인사고과 {

    public int solution(int[][] scores) {
        int answer = 1;

        int[] whanho = scores[0];

        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        int maxReview = 0;
        int target = whanho[0] + whanho[1];
        for(int[] score : scores) {

            if(score[1] < maxReview) {

                if(score == whanho) {
                    return -1;
                }
            } else {
                maxReview = score[1];
                if(score[0] + score[1] > target) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
