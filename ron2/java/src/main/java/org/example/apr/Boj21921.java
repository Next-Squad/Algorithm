package org.example.apr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj21921 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] visitors = new int[n+1];
        st = new StringTokenizer(br.readLine());
        visitors[1] = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= n; i++) {
            visitors[i] = Integer.parseInt(st.nextToken()) + visitors[i-1];
        }

        int left = 0;
        int right = m;
        int max = 0;
        int count = 1;
        while(right <= n) {

            int temp = visitors[right] - visitors[left];
            if(temp == max) {
                count++;
            } else if (temp > max) {
                count = 1;
                max = temp;
            }
            left++;
            right++;
        }
        if(max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }

    }


}
