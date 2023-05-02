package org.example.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj2174 {

    static final String failMessage = "Robot %s crashes into %s";
    static int a;
    static int b;

    static int[][] board;
    static List<Robot> robots;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static Map<String, Integer> dirMap = Map.of(
            "N", 0,
            "E", 1,
            "S", 2,
            "W", 3);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        board = new int[b][a];

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        robots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            robots.add(new Robot(dirMap.get(dir), y-1, x-1));
            board[y-1][x-1] = i+1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int robotNumber = Integer.parseInt(st.nextToken());
            String command = st.nextToken();
            int count = Integer.parseInt(st.nextToken());

            Robot robot = robots.get(robotNumber-1);
            while(count-- > 0) {

                if(command.equals("L")) {
                    // 좌
                    robot.dir--;
                    if(robot.dir < 0) {
                        robot.dir = 3;
                    }
                    continue;
                } else if (command.equals("R")) {
                    // 우
                    robot.dir++;
                    robot.dir %= 4;
                    continue;

                }

                int nx = robot.x + dx[robot.dir];
                int ny = robot.y + dy[robot.dir];

                if(nx < 0 || ny < 0 || nx >= b || ny >= a) {
                    System.out.println(String.format(failMessage, robotNumber, "the wall"));
                    return;
                }

                if(board[nx][ny] != 0) {
                    System.out.println(String.format(failMessage, robotNumber, "robot " + board[nx][ny]));
                    return;
                }
                board[nx][ny] = robotNumber;
                board[robot.x][robot.y] = 0;
                robot.x = nx;
                robot.y = ny;
            }

        }
        System.out.println("OK");
    }
    static class Robot {
        int dir;
        int x;
        int y;

        public Robot(int dir, int x, int y) {
            this.dir = dir;
            this.x = x;
            this.y = y;
        }
    }
}
