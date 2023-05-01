package org.example.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj13418 {

    static int[] parents;
    static List<Node> nodes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()) + 1;
        int m = Integer.parseInt(st.nextToken()) + 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            nodes.add(new Node(s, d, t));
        }
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        Collections.sort(nodes, (o1, o2) -> o1.type - o2.type);

        int max = 0;
        for (int i = 0; i < m; i++) {
            Node node = nodes.get(i);
            if(find(node.start) != find(node.dest)) {
                union(node.start, node.dest);

                if(node.type == 0) {
                    max++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        int min = 0;
        for (int i = m-1; i >= 0; i--) {
            Node node = nodes.get(i);
            if(find(node.start) != find(node.dest)) {
                union(node.start, node.dest);

                if(node.type == 0) {
                    min++;
                }
            }
        }

        int answer = max * max - min * min;
        System.out.println(answer);
    }

    private static int find(int x) {
        if(parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y) {
            parents[y] = x;
        }
    }

    private static class Node {
        int start;
        int dest;
        int type;

        public Node(int start, int dest, int type) {
            this.start = start;
            this.dest = dest;
            this.type = type;
        }
    }
}
