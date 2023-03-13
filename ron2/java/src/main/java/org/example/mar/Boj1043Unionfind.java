package org.example.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1043Unionfind {

    private static int n;
    private static int m;
    private static int[] people;
    private static List<List<Integer>> parties = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        people = new int[n+1];
        for (int i = 0; i < people.length; i++) {
            people[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        boolean[] knows = new boolean[n+1];
        while (st.hasMoreTokens()) {
            knows[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            List<Integer> members = new ArrayList<>();

            int temp = Integer.parseInt(st.nextToken());
            members.add(temp);

            for (int j = 1; j < count; j++) {
                int mem = Integer.parseInt(st.nextToken());
                members.add(mem);
                union(temp, mem);
            }
            parties.add(members);
        }

        for (int i = 1; i <= n; i++) {
            if(knows[i]) {
                int root = find(i);

                for (int j = 1; j <= n; j++) {
                    if(find(j) == root) {
                        knows[j] = true;
                    }
                }
            }
        }

        int answer = m;
        for (int i = 0; i < m; i++) {

            for(int j = 1; j<=n; j++){
                if(knows[j]) {
                    if(parties.get(i).contains(j)) {
                        answer--;
                        break;
                    }
                }
            }

        }

        System.out.println(answer);

    }

    private static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA != parentB) {
            people[parentB] = parentA;
        }
    }

    private static int find(int member) {
        if (people[member] == member) {
            return member;
        }
        people[member] = find(people[member]);
        return people[member];

    }
}
