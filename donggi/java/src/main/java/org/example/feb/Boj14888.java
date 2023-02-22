package org.example.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14888 {

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] operators = new int[4];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < operators.length; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        Boj14888 s = new Boj14888();
        System.out.println(s.solution(N, numbers, operators));
    }

    public String solution(int n, int[] numbers, int[] operators) {
        dfs(numbers[0], 1, n, numbers, operators);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        sb.append(max).append('\n');
        sb.append(min);
        return sb.toString();
    }

    private void dfs(int number, int depth, int n, int[] numbers, int[] operators) {
        if (depth == n) {
            // 갱신
            max = Math.max(max, number);
            min = Math.min(min, number);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                if (i == 0) {
                    // 덧셈
                    dfs(number + numbers[depth], depth + 1, n, numbers, operators);
                } else if (i == 1) {
                    // 뺄셈
                    dfs(number - numbers[depth], depth + 1, n, numbers, operators);
                } else if (i == 2) {
                    // 곱셈
                    dfs(number * numbers[depth], depth + 1, n, numbers, operators);
                } else {
                    // 나눗셈
                    dfs(number / numbers[depth], depth + 1, n, numbers, operators);
                }
                operators[i]++;
            }
        }
    }
}
