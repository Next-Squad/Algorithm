package org.example.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1405 {
    // 동 서 남 북
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,1,-1};

    private static boolean[][] check;

    private static int n;
    private static double[] percents = new double[4];

    private static double result = 0D;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            percents[i] = Double.parseDouble(st.nextToken()) * 0.01;
        }

        check = new boolean[30][30];
        check[15][15] = true;
        dfs(15,15, 0, 1);

        System.out.println(result);

    }

    private static void dfs(int x, int y, int depth, double percent) {

        if(depth == n) {
            result += percent;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= 30 || ny >= 30) {
                continue;
            }

            if(!check[nx][ny]) {
                check[nx][ny] = true;
                dfs(nx, ny, depth + 1, percent * percents[i]);
                check[nx][ny] = false;
            }
        }
    }
}
