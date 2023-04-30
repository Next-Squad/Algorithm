package org.example.apr;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16234 {

    static int n;
    static int l;
    static int r;
    static int[][] board;
    static boolean[][] visit;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check = true;
        int answer = 0;
        while(check) {
            check = false;
            visit = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!visit[i][j]) {
                        bfs(i,j);
                    }
                }
            }
            if(check) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int x, int y) {
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        int sum = 0;
        visit[x][y] = true;
        Point point = new Point(x, y);
        List<Point> union = new ArrayList<>();
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int count = board[current.x][current.y];
            sum += count;
            union.add(current);
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                int temp = Math.abs(count - board[nx][ny]);
                if(!visit[nx][ny] && temp >= l && temp <= r) {
                    visit[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
            }

        }
        int size = union.size();
        if(size > 1) {
            check = true;
            move(union, sum/size);
        }

    }

    private static void move(List<Point> union, int avg) {
        for (Point point : union) {
            board[point.x][point.y] = avg;
        }
    }


}
