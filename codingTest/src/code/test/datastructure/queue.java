package code.test.datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
* JAVA
* */
public class queue {
    public static void main(String[] args){
        // java 에서는 LinkedList 사용해서 큐를 구현
        Queue<String> queue = new LinkedList();

        //  추가 : add, offer -> 추가 되면 true를 반환함
        queue.add("item1");
        queue.add("item2");
        queue.offer("item3");


        // for 문으로 출력
        for(String a :queue){
            System.out.println(a);
        }

        queue.poll();
        // 첫번째 값 반환하고 제거
        queue.remove();
        // 삭제
        queue.clear();
        // 초기화
    }

}
