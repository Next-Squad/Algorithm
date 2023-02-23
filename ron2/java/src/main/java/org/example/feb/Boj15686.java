package org.example.feb;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj15686 {

    private static int N;
    private static int M;

    private static List<Point> houses = new ArrayList<>();
    private static List<Point> chickens = new ArrayList<>();
    private static int minResult = Integer.MAX_VALUE;
    private static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());

                if(value == 1) {
                    houses.add(new Point(i, j));
                }
                if(value == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }
        check = new boolean[chickens.size()];
        dfs(0, 0);
        System.out.println(minResult);

    }

    private static void dfs(int index, int count) {
        if(count == M) {
            calculate();
            return;
        }

        for (int i = index; i < chickens.size(); i++) {
            check[i] = true;
            dfs(i + 1, count + 1);
            check[i] = false;
        }
    }

    private static void calculate() {
        int sum = 0;
        for (Point house : houses) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < chickens.size(); i++) {
                if(check[i]) {
                    min = Math.min(min, getDist(house, chickens.get(i)));
                }
            }
            sum += min;
        }
        minResult = Math.min(minResult, sum);
    }

    private static int getDist(Point house, Point chicken) {
        return Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
    }
}
