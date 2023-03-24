package main.java.org.example.mar.bj1943;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < 3; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n];
            int[] counts = new int[n];
            int totalValue = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                coins[i] = Integer.parseInt(st.nextToken());
                counts[i] = Integer.parseInt(st.nextToken());
                totalValue += coins[i] * counts[i];
            }

            if (totalValue % 2 != 0) {
                sb.append(0).append('\n');
            } else {
                boolean[] dp = new boolean[totalValue / 2 + 1];
                dp[0] = true;

                for (int i = 0; i < n; i++) {
                    int coin = coins[i];
                    int count = counts[i];
                    for (int k = 1; k <= count; k *= 2) {
                        for (int j = totalValue / 2; j >= k * coin; j--) {
                            dp[j] |= dp[j - k * coin];
                        }
                        count -= k;
                    }
                    if (count > 0) {
                        for (int j = totalValue / 2; j >= count * coin; j--) {
                            dp[j] |= dp[j - count * coin];
                        }
                    }
                }

                if (dp[totalValue / 2]) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            }
        }
        System.out.print(sb);
    }
}
