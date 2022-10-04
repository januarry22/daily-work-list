package code.test.programmers;

import java.awt.*;
import java.util.*;

/*
 * [프로그래머스] - 이중우선순위큐
 * */
public class lessons42628 {
    public static PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
    public static PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(Comparator.reverseOrder());

    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int[] answer = solution(operations);

        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        for (String str : operations) {
            String command = str.substring(0, 1);
            int offer = Integer.valueOf(str.substring(2, str.length()));
            if (command.equals("D") && minQueue.size() < 1) {
                continue;
            }
            if (command.equals("I")) {
                minQueue.add(offer);
                maxQueue.add(offer);
                continue;
            }
            if (offer < 0) {
                int min = minQueue.poll();
                maxQueue.remove(min);
                continue;
            }

            int max = maxQueue.poll();
            minQueue.remove(max);
        }

        if(minQueue.size()>0){
            answer[0] = maxQueue.poll();
            answer[1] = minQueue.poll();
            return answer;
        }else{
            return new int[]{0,0};
        }
    }

}
