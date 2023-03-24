package org.example.mar;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삼성 SW 역량테스트 2015 하반기 1번 문제
public class 바이러스검사 {

    private static int n;
    private static int[] stores;
    private static int manager;
    private static int member;
    private static long result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stores = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            stores[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        manager = Integer.parseInt(st.nextToken());
        member = Integer.parseInt(st.nextToken());

        for(int customer : stores) {
            result += cal(customer);
        }
        System.out.println(result);
    }

    private static int cal(int customer) {
        int temp = customer - manager;
        if(temp <= 0) {
            return 1;
        }
        int ans = temp / member;
        if(temp % member != 0) {
            ans += 1;
        }
        return ans + 1;
    }
}
