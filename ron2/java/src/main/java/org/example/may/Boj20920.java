package org.example.may;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj20920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            if(temp.length() < m) {
                continue;
            }
            counts.put(temp,counts.getOrDefault(temp, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        counts.keySet().stream().sorted(((o1, o2) -> {
            Integer c1 = counts.get(o1);
            Integer c2 = counts.get(o2);
            if (c1.equals(c2)) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
            return c2 - c1;
        })).forEach(a -> sb.append(a).append('\n'));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }
}
