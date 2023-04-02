package org.example.apr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17182 {

    private static int n;
    private static int s;
    private static int[][] graph;

    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        boolean[] visit = new boolean[n];
        visit[s] = true;
        dfs(s, 1, 0, visit);
        System.out.println(result);
    }

    private static void dfs(int start, int count, int time, boolean[] visit) {
        if(count == n) {
            result = Math.min(time, result);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(i, count + 1, time + graph[start][i], visit);
                visit[i] = false;
            }
        }
    }
}
