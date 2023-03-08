package org.example.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1043 {

    private static int n;
    private static int m;
    private static boolean[] people;
    private static boolean[] check;
    private static List<List<Integer>> parties = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        people = new boolean[n+1];
        check = new boolean[m];

        st = new StringTokenizer(br.readLine());

        Integer.parseInt(st.nextToken());
        while (st.hasMoreTokens()) {
            int know = Integer.parseInt(st.nextToken());
            people[know] = true;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int members = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < members; j++) {
                int temp = Integer.parseInt(st.nextToken());
                party.add(temp);
            }
            parties.add(party);
        }
        System.out.println(search());
    }

    private static int search() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < people.length; i++) {
            if(people[i]) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {

            int temp = queue.poll();

            for (int i = 0; i < m; i++) {
                if(check[i]) {
                    continue;
                }

                if(parties.get(i).contains(temp)) {
                    check[i] = true;

                    parties.get(i).stream()
                            .filter(t -> !people[t])
                            .forEach(t -> {
                        people[t] = true;
                        queue.add(t);
                    });
                }

            }

        }
        int answer = m;
        for (int i = 0; i < m; i++) {
            if(check[i]) {
                answer--;
            }
        }

        return answer;
    }
}
