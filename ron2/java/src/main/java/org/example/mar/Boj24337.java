package org.example.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 실패
public class Boj24337 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int size = Integer.parseInt(st.nextToken());
        int[] heights = new int[size];

        if(size == 1) {
            System.out.println(1);
            return;
        }
        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());
        int top = 1;
        for (int i = 0; i < left; i++) {
            heights[i] = i+1;
            top = Math.max(top, heights[i]);
        }
        int k = 0;
        int rightIndex;
        for (int i = size - 1; i >= size - right; i--) {
            if(heights[i] != 0) {
                break;
            }
            heights[i] = ++k;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if(heights[i] == 0) {
                heights[i] = 1;
            }
            sb.append(heights[i]).append(" ");
        }
        System.out.println(sb);
    }
}
