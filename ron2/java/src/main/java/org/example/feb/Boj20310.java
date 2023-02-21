package org.example.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj20310 {
    // 2월 21일 풀이 완료
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();

        char[] chars = target.toCharArray();
        int one = 0;
        int zero = 0;
        for (char aChar : chars) {
            if (aChar == '0') {
                zero++;
            } else {
                one++;
            }
        }
        one /= 2;
        zero /= 2;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                chars[i] = 'A';
                one--;
            }
            if(one == 0) {
                break;
            }

        }
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '0') {
                chars[i] = 'A';
                zero--;
            }
            if(zero == 0) {
                break;
            }

        }

        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
           if(Character.isDigit(aChar)) {
               sb.append(aChar);
           }
        }

        System.out.println(sb);
    }
}
