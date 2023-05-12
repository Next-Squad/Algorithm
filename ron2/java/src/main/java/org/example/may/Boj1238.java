package org.example.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1238 {

    static int n;
    static int m;
    static int x;
    static List<List<Node>> graph = new ArrayList<>();
    static List<List<Node>> reverse = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(d,w));
            reverse.get(d).add(new Node(s,w));
        }

        int[] dist = dijkstra(x, graph);
        int[] reverseDist = dijkstra(x, reverse);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(dist[i] + reverseDist[i], max);
        }
        System.out.println(max);
    }

    private static int[] dijkstra(int start, List<List<Node>> g) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            for(Node next : g.get(curr.dest)) {
                if(dist[next.dest] > dist[curr.dest] + next.weight) {
                    dist[next.dest] = dist[curr.dest] + next.weight;
                    pq.offer(new Node(next.dest, dist[next.dest]));
                }
            }
        }
        return dist;
    }

    private static class Node {
        int dest;
        int weight;

        Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}

