package code.test.datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
* JAVA
* */
public class priorityQueue {
    public static void main(String[] args){
        // 우선순위
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> reverseQueue = new PriorityQueue<>(Comparator.reverseOrder());

        queue.add(1);
        queue.add(89);
        queue.offer(23);

        for(int a :queue){
            System.out.println(a);
        }

        // 첫번째 값 반환하고 제거
        queue.poll();

        // 첫번째 값 반환, 비어있으면 null
        queue.peek();

        // 첫번째 값 반환, 비어있으면 error
        queue.element();

        // 삭제
        queue.remove(89);

        // 초기화
        queue.clear();

    }

}
