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

        int deletedZeros = 0;
        int deletedOnes = 0;
        for (char number : numStr.toCharArray()) {
            if (number == '1') {
                if (deletedOnes < arr[1]) {
                    deletedOnes++;
                } else {
                    sb.append(1);
                }
            } else {
                if (deletedZeros < arr[0]) {
                    sb.append(0);
                    deletedZeros++;
                }
            }
        }
        System.out.println(sb);
    }
}
