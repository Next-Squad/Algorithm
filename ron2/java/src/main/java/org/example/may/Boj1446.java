package org.example.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1446 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] counts = new int[d+1];
        for (int i = 0; i < d+1; i++) {
            counts[i] = i;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.start == o1.dest) {
                return o1.dest - o2.dest;
            }
            return o1.start - o2.start;
        });
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            pq.offer(new Node(start, dest, length));
        }

        while (!pq.isEmpty()) {
            Node shortCut = pq.poll();
            if(shortCut.dest > d) {
                continue;
            }
            if(shortCut.dest - shortCut.start < shortCut.length) {
                continue;
            }
            for (int i = 1; i <= shortCut.start; i++) {
                counts[i] = Math.min(counts[i-1] + 1, counts[i]);
            }
            counts[shortCut.dest] = Math.min(counts[shortCut.start] + shortCut.length, counts[shortCut.dest]);
        }


        for (int i = 1; i <= d; i++) {
            counts[i] = Math.min(counts[i-1] + 1, counts[i]);
        }

        System.out.println(counts[d]);
    }

    static class Node {
        int start;
        int dest;
        int length;

        public Node(int start, int dest, int length) {
            this.start = start;
            this.dest = dest;
            this.length = length;
        }
    }


}
