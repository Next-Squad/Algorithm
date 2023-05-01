package org.example.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2056 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<List<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tasks.add(new ArrayList<>());
        }
        int[] times = new int[n+1];
        int[] counts = new int[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int first = Integer.parseInt(st.nextToken());
                counts[i]++;
                tasks.get(first).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] finishTimes = new int[n+1];
        for (int i = 1; i <= n; i++) {
            finishTimes[i] = times[i];
            if(counts[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {

            Integer current = queue.poll();

            for (Integer task: tasks.get(current)) {
                counts[task]--;
                finishTimes[task] = Math.max(finishTimes[task], finishTimes[current] + times[task]);
                if(counts[task] == 0) {
                    queue.offer(task);
                }
            }
        }
        int answer = 0;
        for (int result : finishTimes) {
            answer = Math.max(answer, result);
        }
        System.out.println(answer);
    }


}
