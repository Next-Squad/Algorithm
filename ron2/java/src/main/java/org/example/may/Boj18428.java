package org.example.may;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj18428 {

    static int n;
    static String[][] board;
    static List<Point> teachers = new ArrayList<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new String[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
               board[i][j] = st.nextToken();
               if(board[i][j].equals("T")) {
                   teachers.add(new Point(i, j));
               }
            }
        }
        dfs(0,0);
        if(answer) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void dfs(int x, int depth) {
        if(depth == 3) {
            if(check()) {
                answer = true;
            };
            return;
        }

        for (int i = x; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j].equals("X")) {
                    board[i][j] = "O";
                    dfs(i, depth+1);
                    board[i][j] = "X";
                }
            }
        }
        
    }

    private static boolean check() {
        for (Point teacher: teachers) {
            for (int i = 0; i < 4; i++) {
                int nx = teacher.x;
                int ny = teacher.y;
                while(true) {
                    nx += dx[i];
                    ny += dy[i];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny].equals("O")) {
                        break;
                    }
                    if(board[nx][ny].equals("S")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
