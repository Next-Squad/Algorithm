package org.example.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj6087 {

    private static int[] dx = {0,-1,0,1};
    private static int[] dy = {1,0,-1,0};
    private static int h;
    private static int w;

    private static char[][] board;
    private static int[][][] visit;


    private static Set<Point> points = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        board = new char[h][w];
        visit = new int[h][w][4];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Arrays.fill(visit[i][j], Integer.MAX_VALUE);
            }
        }

        for (int i = 0; i < h; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(board[i][j] == 'C') {
                    System.out.println(bfs(new Point(i, j, 0, -1)));
                    return;
                }
            }
        }



    }

    private static int bfs(Point point) {
        Queue<Point> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.count));
        queue.offer(point);
        for (int i = 0; i < 4; i++) {
            visit[point.x][point.y][i] = 0;
        }
        board[point.x][point.y] = '.';

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (board[current.x][current.y] == 'C') {
                return current.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(!isInBound(nx, ny)) {
                    continue;
                }
                if(current.dir == -1 || current.dir == i) {
                    if(visit[nx][ny][i] > current.count) {
                        visit[nx][ny][i] = current.count;
                        queue.offer(new Point(nx, ny, current.count, i));
                    }
                } else {
                    if(visit[nx][ny][current.dir] > current.count + 1) {
                        visit[nx][ny][current.dir] = current.count + 1;
                        queue.offer(new Point(nx, ny, current.count + 1, i));
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isInBound(int x, int y) {
        return x >= 0 && y >= 0 && x < h && y < w && board[x][y] != '*';
    }

    private static class Point{
        int x;
        int y;
        int count;
        int dir;

        public Point(int x, int y, int count, int dir) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.dir = dir;
        }
    }
}
