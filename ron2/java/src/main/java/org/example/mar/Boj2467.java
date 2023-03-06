package org.example.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] longs = new long[n];
        for (int i = 0; i < n; i++) {
            longs[i] = Long.parseLong(st.nextToken());
        }

        int left = 0;
        int right = n - 1;
        long min = Long.MAX_VALUE;
        int resultLeft = 0;
        int resultRight = n - 1;

        while(left<right) {
            long sum = longs[left] + longs[right];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                resultLeft = left;
                resultRight = right;
            }
            if (sum>=0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(longs[resultLeft] + " " + longs[resultRight]);
    }
}
