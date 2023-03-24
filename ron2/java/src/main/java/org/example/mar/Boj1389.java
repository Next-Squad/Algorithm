package org.example.mar;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1389 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n + 1][n + 1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n + 1; j++) {
                graph[i][j] = 9999999;
                if(i == j) {
                    graph[i][j] = 0;
                }

            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            graph[s][d] = 1;
            graph[d][s] = 1;
        }

        for (int k = 1; k < n +1; k++) {
            for (int i = 1; i < n +1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        int min = 9999999;
        int minMember = 0;

        for (int i = 1; i < n + 1; i++) {
            int count = 0;
            for (int j = 1; j < n+1; j++) {
                count += graph[i][j];
            }
            if(count < min) {
                min = count;
                minMember = i;
            }
        }

        System.out.println(minMember);
    }
}
