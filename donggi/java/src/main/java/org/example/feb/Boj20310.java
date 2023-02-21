package org.example.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj20310 {
    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Boj20310 s = new Boj20310();
        System.out.println(s.solution(str));
    }

    public String solution(String str) {
        String[] split = str.split("");

        return sb.toString();
    }
}
