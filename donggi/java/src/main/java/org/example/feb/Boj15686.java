package org.example.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj15686 {

    int min = Integer.MAX_VALUE;
    int[][] map;
    int[][] arr;
    List<int[]> homePoint = new ArrayList<>();
    List<int[]> chickenPoint = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] inputs = new String[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = br.readLine();
        }

        Boj15686 s = new Boj15686();
        System.out.println(s.solution(N, M, inputs));
    }

    public int solution(int n, int m, String[] inputs) {
        map = new int[n][n];
        arr = new int[m][2];
        for (int i = 0; i < n; i++) {
            String[] s = inputs[i].split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                if (map[i][j] == 1) {
                    homePoint.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    chickenPoint.add(new int[]{i, j});
                }
            }
        }

        dfs(0, n, m);

        return min;
    }

    private void dfs(int depth, int n, int m) {
        if (depth == m) { // 살릴 치킨집 개수
            calculate(n, m);
            return;
        }

        for (int i = 0; i < chickenPoint.size(); i++) {
            int[] ints = chickenPoint.get(i);
            map[ints[0]][ints[1]] = 0;
            arr[depth][0] = ints[0];
            arr[depth][1] = ints[1];
            dfs(depth + 1, n, m);
        }

//        for (int i = depth; i < n; i++) {
//            for (int j = depth; j < n; j++) {
//                if (map[i][j] == 2) {
//                    // 치킨집 없앴다가 -> 가 아니고 M개의 치킨집 배열에 넣고
//                    // 치킨집 좌표 저장
//                    arr[depth][0] = i;
//                    arr[depth][1] = j;
//                    map[i][j] = 0;
//                    dfs(depth + 1, n, m);
//                    // 다시 치킨집 되돌려놓기
//                    map[i][j] = 2;
//                }
//            }
//        }
    }

    private void calculate(int n, int m) {
        int sum = 0;

        for (int i = 0; i < homePoint.size(); i++) {
            int[] ints = homePoint.get(i);
            int minmin = Integer.MAX_VALUE;
            for (int k = 0; k < m; k++) {
                // 집에서 각 치킨집 거리까지의 치킨거리를 계산하고자 함
                minmin = Math.min(minmin, (Math.abs(arr[k][0] - ints[0]) + Math.abs(arr[k][1] - ints[1])));
            }
            // 현재 집의 최소 치킨거리를 sum 에 저장
            sum += minmin;
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//
//                if (map[i][j] == 1) { // 집이면 치킨거리 계산
//                    int minmin = Integer.MAX_VALUE;
//                    for (int k = 0; k < m; k++) {
//                        // 집에서 각 치킨집 거리까지의 치킨거리를 계산하고자 함
//                        minmin = Math.min(minmin, (Math.abs(arr[k][0] - i) + Math.abs(arr[k][1] - j)));
//                    }
//                    // 현재 집의 최소 치킨거리를 sum 에 저장
//                    sum += minmin;
//                }
//            }
//        }

        if (min > sum) {
            min = sum;
        }
    }

}
