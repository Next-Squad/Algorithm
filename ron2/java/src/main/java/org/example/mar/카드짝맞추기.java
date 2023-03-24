package org.example.mar;

import javafx.geometry.Point3D;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

// 프로그래머스 카드짝맞추기
public class 카드짝맞추기 {

    int minCount = Integer.MAX_VALUE;
    int[][] cardBoard;
    Point[][] cardPosition = new Point[7][2];

    int[] dx = {0,-1,0,1};
    int[] dy = {1,0,-1,0};
    public static void main(String[] args) {
               int[][] board = {{1, 0, 0, 3}, {2, 0, 0, 0}, {0, 0, 0, 2}, {3, 0, 1, 0}};
//     int[][] board =  {{3, 0, 0, 2}, {0, 0, 1, 0}, {0, 1, 0, 0}, {2, 0, 0, 3}};
        int r = 1;
        int c = 0;
        카드짝맞추기 카드짝맞추기 = new 카드짝맞추기();
        System.out.println(카드짝맞추기.solution(board, r, c));
    }

    public int solution(int[][] board, int r, int c) {
        cardBoard = board;
        Set<Integer> cardSet = findCardSet();
        cardSet.forEach(System.out::println);
        System.out.println("====");
        permutation(cardSet, new boolean[cardSet.size() + 1], new Point(r, c, 0), 0);
        return minCount;
    }

    public Set<Integer> findCardSet() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < cardBoard.length; i++) {
            int[] row = cardBoard[i];
            for (int j = 0; j < row.length; j++) {
                if(row[j] != 0) {
                    if(cardPosition[row[j]][0] == null) {
                        cardPosition[row[j]][0] = new Point(i, j, 0);
                    } else {
                        cardPosition[row[j]][1] = new Point(i, j, 0);
                    }
                    set.add(row[j]);
                }
            }
        }
        return set;
    }

    public void permutation(Set<Integer> cardSet, boolean[] visit, Point point, int count) {
        if(count == cardSet.size()) {
            minCount = Math.min(minCount, point.count);
            System.out.println("=====");
            return;
        }

        for(int i : cardSet) {
            if(!visit[i]) {
                Point shortRoot = findShortRoot(point, i);
                shortRoot.count += 2;
                change(i, 0);
                visit[i] = true;
                System.out.println(shortRoot.count);
                permutation(cardSet, visit, shortRoot, count + 1);
                change(i, i);
                visit[i] = false;
            }

        }

    }

    private void change(int target, int num) {
        cardBoard[cardPosition[target][0].x][cardPosition[target][0].y] = num;
        cardBoard[cardPosition[target][1].x][cardPosition[target][1].y] = num;
    }

    private Point findShortRoot(Point point, int targetNumber) {

        Queue<Point> queue = new ArrayDeque<>();
        int startX = cardPosition[targetNumber][0].x;
        int startY = cardPosition[targetNumber][0].y;
        int endX = cardPosition[targetNumber][1].x;
        int endY = cardPosition[targetNumber][1].y;
        boolean[][] visit = new boolean[4][4];
        queue.offer(point);
        visit[point.x][point.y] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            //visit[current.x][current.y] = true;

            if(((current.x == startX && current.y == startY) || (current.x == endX && current.y == endY)) && current.check) {
                return current;
            }
            if (((current.x == startX && current.y == startY) || (current.x == endX && current.y == endY))) {
                current.check = true;
            }

            for (int i = 0; i <4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || visit[nx][ny]) {
                    continue;
                }
                visit[nx][ny] = true;
                queue.add(new Point(nx, ny, current.count + 1, current.check));
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x;
                int ny = current.y;
                while (true) {
                    nx += dx[i];
                    ny += dy[i];
                    if(nx == 4 || ny == 4 || nx == -1 || ny == -1) {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                    if(cardBoard[nx][ny] != 0) {
                        break;
                    }
                }
                if(!visit[nx][ny]) {
                    //visit[nx][ny] = true;
                    queue.add(new Point(nx, ny, current.count + 1, current.check));
                }
            }
        }
        return null;
    }

    private static class Point {
        int x;
        int y;
        int count;

        boolean check;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public Point(int x, int y, int count, boolean check) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.check = check;
        }
    }
}
