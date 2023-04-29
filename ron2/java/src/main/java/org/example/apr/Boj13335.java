package org.example.apr;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj13335 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Queue<Integer> ready = new LinkedList<>();
        Queue<Point> bridge = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            ready.offer(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        int current = 0;
        while(!ready.isEmpty()) {
            answer++;
            Integer temp = ready.peek();
            if(current + temp <= l) {
                ready.poll();
                current += temp;
                bridge.offer(new Point(temp, answer));
            }

            Point truck = bridge.peek();
            if(answer == truck.y + w - 1) {
                bridge.poll();
                current -= truck.x;
            }
        }
        System.out.println(answer + w);
    }
}
