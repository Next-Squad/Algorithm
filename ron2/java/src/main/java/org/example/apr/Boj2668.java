package org.example.apr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj2668 {

    static int[] arr;
    static List<Integer> result;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        result = new ArrayList<>();
        visit = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            visit[i] = true;
            dfs(i, i);
            visit[i] = false;
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (Integer num : result) {
            System.out.println(num);
        }

    }

    private static void dfs(int start, int dest) {
        int temp = arr[start];
        if(temp == dest) {
            result.add(start);
            return;
        }

        if(!visit[temp]) {
            visit[temp] = true;
            dfs(temp, dest);
            visit[temp] = false;
        }

    }
}
