package org.example.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj2310 {

    private static Room[] rooms;
    private static boolean[] visit;
    private static boolean flag;
    private static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            count = Integer.parseInt(br.readLine());
            rooms = new Room[count+1];
            if (count == 0) {
                break;
            }
            for (int i = 1; i <= count; i++) {
                st = new StringTokenizer(br.readLine());
                String type = st.nextToken();
                int value = Integer.parseInt(st.nextToken());
                List<Integer> nextRooms = new ArrayList<>();
                while (true) {
                    int room = Integer.parseInt(st.nextToken());
                    if(room == 0) {
                        break;
                    }
                    nextRooms.add(room);
                }
                rooms[i] = new Room(type, value, nextRooms);
            }
            flag = false;
            visit = new boolean[count + 1];
            dfs(1, 0);

            System.out.println(flag ? "Yes" : "No");
        }
    }

    private static void dfs(int start, int money) {
        if(flag) {
            return;
        }

        Room current = rooms[start];
        if(current.type.equals("L")) {
            if(money < current.value) {
                money = current.value;
            };
        } else if(current.type.equals("T")) {
            money -= current.value;
        }

        if(money < 0) {
            return;
        }

        if(start == count) {
            flag = true;
            return;
        }

        visit[start] = true;
        List<Integer> nextRooms = current.nextRooms;
        for (int i = 0; i < nextRooms.size(); i++) {
            if(!visit[nextRooms.get(i)]) {
                dfs(nextRooms.get(i), money);
            }
        }
        visit[start] = false;
    }

    private static class Room {

        String type;
        int value;
        List<Integer> nextRooms;

        public Room(String type, int value, List<Integer> nextRooms) {
            this.type = type;
            this.value = value;
            this.nextRooms = nextRooms;
        }
    }
}

