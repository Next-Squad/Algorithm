package org.example.may;
import java.util.*;

public class Programmers_이중우선순위큐 {

    public static void main(String[] args) {
        Programmers_이중우선순위큐 programmers_이중우선순위큐 = new Programmers_이중우선순위큐();
        String[] commands = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] solution = programmers_이중우선순위큐.solution(commands);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2,o1));
        PriorityQueue<Integer> minpq;
        for(String command : operations) {
            String[] temp = command.split(" ");
            int num = Integer.parseInt(temp[1]);

            if(temp[0].equals("I")) {
               pq.offer(num);
            } else {
                if(num < 0 && !pq.isEmpty()) {
                    minpq = new PriorityQueue<>();
                    minpq.addAll(pq);
                    minpq.poll();
                    pq.clear();
                    pq.addAll(minpq);
                } else if(num > 0 && !pq.isEmpty()) {
                   pq.poll();
                }
            }
        }

        if(pq.size() == 0) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = pq.peek();
            minpq = new PriorityQueue<>();
            minpq.addAll(pq);
            answer[1] = minpq.peek();

        }

        return answer;
    }
}
