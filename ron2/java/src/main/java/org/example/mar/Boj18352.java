package org.example.mar;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj18352 {

    private static int n;
    private static int m;
    private static int k;
    private static int x;
    private static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n ; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            map.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }
        Set<Integer> result = bfs();
        if(result.isEmpty()) {
            System.out.println(-1);
        } else {
            result.stream().sorted(Integer::compareTo).forEach(System.out::println);
        }

    }

    private static Set<Integer> bfs() {
        Set<Integer> result = new HashSet<>();
        boolean[] check = new boolean[n+1];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, 0));

        while (!queue.isEmpty()) {

            Point point = queue.poll();
            if(check[point.x]) {
                continue;
            }
            check[point.x] = true;
            if(point.y == k) {
                result.add(point.x);
                continue;
            }
            for (int i : map.get(point.x)) {
                queue.add(new Point(i,point.y + 1));
            }
        }
        return result;
    }

}
