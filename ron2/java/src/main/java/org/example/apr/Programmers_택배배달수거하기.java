package org.example.apr;

import java.util.Stack;

public class Programmers_택배배달수거하기 {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<Integer> delivery = new Stack<>();
        Stack<Integer> pickup = new Stack<>();

        for(int i = 0; i < deliveries.length; i++) {

            for(int j = 0; j < deliveries[i]; j++) {
                delivery.push(i+1);
            }

            for(int j = 0; j < pickups[i]; j++) {
                pickup.push(i+1);
            }

        }


        while(!delivery.isEmpty() && !pickup.isEmpty()) {
            int dLocation = delivery.peek();
            int pLocation = pickup.peek();

            for(int i = 0; i < cap; i++) {
                if(!delivery.isEmpty()) {
                    delivery.pop();
                }
                if(!pickup.isEmpty()) {
                    pickup.pop();
                }
            }

            answer += Math.max(dLocation, pLocation) * 2L;
        }

        while (!delivery.isEmpty()) {
            int dLocation = delivery.peek();

            for (int i = 0; i < cap; i++) {
                if (!delivery.isEmpty()) {
                    delivery.pop();
                }
            }
            answer += dLocation * 2L;
        }

        while (!pickup.isEmpty()) {
            int pLocation = pickup.peek();

            for (int i = 0; i < cap; i++) {
                if (!pickup.isEmpty()) {
                    pickup.pop();
                }
            }
            answer += pLocation * 2L;
        }

        return answer;
    }
}
