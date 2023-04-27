package org.example.apr;

import java.util.Arrays;
import java.util.Objects;

public class Programmers_이모티콘할인행사 {

    public static void main(String[] args) {
        Programmers_이모티콘할인행사 solution = new Programmers_이모티콘할인행사();
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};
        int[] result = solution.solution(users, emoticons);
        System.out.println(Arrays.toString(result));
    }
    private int count;
    private int total;
    private int[] rates = {10,20,30,40};

    private int[] emoticons;
    private int[][] users;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        this.users = users;
        this.emoticons = emoticons;

        dfs(new int[emoticons.length], 0);
        answer[0] = count;
        answer[1] = total;
        return answer;
    }

    void dfs(int[] dis, int depth) {

        if(depth == emoticons.length) {
            checkResult(dis);
            return;
        }

        for(int rate : rates) {
            dis[depth] = rate;
            dfs(dis, depth + 1);
        }
    }

    void checkResult(int[] dis) {
        int currentCount = 0;
        int currentTotal = 0;
        for(int[] user : users) {
            int tempTotal = 0;
            for(int i = 0; i < emoticons.length; i++) {
                if(dis[i] >= user[0]) {
                    tempTotal += cal(emoticons[i], dis[i]);
                }
            }

            if(tempTotal >= user[1]) {
                currentCount++;
            } else {
                currentTotal += tempTotal;
            }
        }
        findResult(currentCount, currentTotal);

    }

    int cal(int cost, int rate) {
        return (cost * (100 - rate))/100;
    }

    void findResult(int currentCount, int currentTotal) {
        if(currentCount > count) {
            count = currentCount;
            total = currentTotal;
        } else if(currentCount == count) {
            total = Math.max(total, currentTotal);
        }
    }
}
