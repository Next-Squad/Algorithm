package org.example.apr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10159 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[][] heavyGraph = new boolean[n+1][n+1];
        boolean[][] lightGraph = new boolean[n+1][n+1];
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            heavyGraph[first][second] = true;
            lightGraph[second][first] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (heavyGraph[i][k] && heavyGraph[k][j]) {
                        heavyGraph[i][j] = true;
                    }

                    if (lightGraph[i][k] && lightGraph[k][j]) {
                        lightGraph[i][j] = true;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                heavyGraph[i][j] |= lightGraph[i][j];
            }
        }

        for (int i = 1; i <= n; i++) {

            int answer = 0;
            for (int j = 1; j <= n; j++) {
                if(i == j) {
                    continue;
                }
                if (!heavyGraph[i][j]) {
                    answer++;
                }
            }
            System.out.println(answer);
        }

    }
}
