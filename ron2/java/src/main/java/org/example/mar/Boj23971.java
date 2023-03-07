package org.example.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj23971 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // w - m
        // h - n
        int width = calculate(w, m);
        int height = calculate(h, n);
        System.out.println(width * height);
    }

    private static int calculate(int size, int dist) {
        int result = size / (dist+1);
        if(size % (dist+1) != 0) {
            return result + 1;
        }
        return result;
    }
}
