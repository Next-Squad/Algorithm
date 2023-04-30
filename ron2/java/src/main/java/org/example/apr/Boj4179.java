package org.example.apr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj4179 {

    static int r;
    static int c;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        char[][] board = new char[r][c];
        Queue<Node> queue = new LinkedList<>();
        Node J = null;
        for (int i = 0; i < r; i++) {
            String raw = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = raw.charAt(j);
                if(board[i][j] == 'J') {
                    J = new Node('J', i, j, 0);
                }
                if(board[i][j] == 'F') {
                    queue.offer(new Node('F', i, j, 0));
                }
            }
        }
        queue.offer(J);

        int answer = solution(queue, board);

        if(answer == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(answer);
        }



    }

    private static int solution(Queue<Node> queue, char[][] board) {
        int answer = -1;
        boolean[][] visit = new boolean[r][c];
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            visit[current.x][current.y] = true;
            if(current.type == 'J') {

                for (int i = 0; i < 4; i++) {
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
                        return current.count + 1;
                    }

                    if(board[nx][ny] != '#' && board[nx][ny] != 'F' && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        queue.offer(new Node('J', nx, ny, current.count + 1));
                    }
                }
            } else {

                for (int i = 0; i < 4; i++) {
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
                        continue;
                    }

                    if(board[nx][ny] != '#' && board[nx][ny] != 'F') {
                        board[nx][ny] = 'F';
                        queue.offer(new Node('F', nx, ny, current.count + 1));
                    }
                }

            }
        }
        return answer;
    }

    static class Node {
        char type;
        int x;
        int y;
        int count;

        public Node(char type, int x, int y, int count) {
            this.type = type;
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
