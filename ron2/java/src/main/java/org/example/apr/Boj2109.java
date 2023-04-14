package org.example.apr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj2109 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Lecture> lectures = new PriorityQueue<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(p,d));
        }

        boolean[] schedule = new boolean[10001];
        int answer = 0;
        while (!lectures.isEmpty()) {
            Lecture temp = lectures.poll();

            int deadline = temp.deadline;
            if(!schedule[deadline]) {
                schedule[deadline] = true;
                answer += temp.pay;
                continue;
            }

            for (int i = deadline - 1; i > 0; i--) {
                if(!schedule[i]) {
                    schedule[i] = true;
                    answer += temp.pay;
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    private static class Lecture implements Comparable<Lecture>{
        int pay;
        int deadline;

        public Lecture(int pay, int deadline) {
            this.pay = pay;
            this.deadline = deadline;
        }

        @Override
        public int compareTo(Lecture o) {
            if(this.pay == o.pay) {
                return o.deadline - this.deadline;
            }
            return o.pay - this.pay;
        }
    }
}
