package org.example.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj18405 {

    static int n;
    static int k;
    static int[][] board;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        while(s-- > 0) {
            bfs();
            if(board[x-1][y-1] != 0) {
                break;
            }
        }

        System.out.println(board[x-1][y-1]);

    }

    private static void bfs() {
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        PriorityQueue<Node> pq = new PriorityQueue<Node>(((o1, o2) -> o1.virus - o2.virus));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] != 0 && !visit[i][j]) {
                    visit[i][j] = true;
                    pq.offer(new Node(board[i][j], i, j));
                }
            }
        }

        while (!pq.isEmpty()) {
            Node temp = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if(board[nx][ny] == 0) {
                    board[nx][ny] = temp.virus;
                }
            }
        }
    }

    static class Node {
        int virus;
        int x;
        int y;

        public Node(int virus, int x, int y) {
            this.virus = virus;
            this.x = x;
            this.y = y;
        }
    }
}
