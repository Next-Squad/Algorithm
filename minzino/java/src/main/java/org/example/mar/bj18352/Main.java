package main.java.org.example.mar.bj18352;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class City implements Comparable<City> {

    int cityNum;
    int weight;

    public City(int cityNum, int weight) {
        this.cityNum = cityNum;
        this.weight = weight;
    }

    @Override
    public int compareTo(City o) {
        return weight - o.weight;
    }

}

public class Main {

    private static final int MAX_DISTANCE = Integer.MAX_VALUE;
    static ArrayList<ArrayList<City>> graph = new ArrayList<>();
    static int[] distance;
    static int N, M, K, X;
    private static void solution(int cityNum) {
        PriorityQueue<City> queue = new PriorityQueue<>();
        boolean[] visit = new boolean[N + 1];
        distance[cityNum] = 0;

        queue.offer(new City(cityNum, 0));

        while (!queue.isEmpty()) {
            City city = queue.poll();
            int num = city.cityNum;

            if (visit[num]) {
                continue;
            }

            visit[num] = true;

            for (City c : graph.get(num)) {

                if (!visit[c.cityNum] && distance[c.cityNum] > (c.weight + distance[num])) {
                    distance[c.cityNum] = c.weight + distance[num];
                    queue.offer(new City(c.cityNum, distance[c.cityNum]));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        Arrays.fill(distance, MAX_DISTANCE);
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(new City(y, 1));
        }

        solution(X);

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == K) {
                sb.append(i).append('\n');
            }
        }

        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }

    }
}
