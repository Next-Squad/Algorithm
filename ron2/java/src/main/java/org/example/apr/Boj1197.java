package org.example.apr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1197 {

    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        List<Node> graph = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.add(new Node(s,d,w));
            graph.add(new Node(d,s,w));
        }
        graph.sort((o1, o2) -> o1.w - o2.w);

        parent = new int[v+1];
        for (int i = 1; i < v+1; i++) {
            parent[i] = i;
        }

        for (Node node : graph) {
            if(!checkParent(node.s, node.d)) {
                union(node.s, node.d);
                result += node.w;
            }
        }

        System.out.println(result);

    }
    private static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y) {
            parent[y] = x;
        }
    }

    private static boolean checkParent(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }

    private static class Node {
        int s;
        int d;
        int w;

        public Node(int s, int d, int w) {
            this.s = s;
            this.d = d;
            this.w = w;
        }
    }


}
