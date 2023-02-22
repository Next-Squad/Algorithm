package main.java.org.example.feb.bj20310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[2];

        String numStr = br.readLine();

        for (int i = 0; i < numStr.length(); i++) {

            arr[numStr.charAt(i) - '0']++;
        }

        arr[0] /= 2;
        arr[1] /= 2;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                sb.append(i);
            }
        }
        System.out.println(sb);
    }
}
