# 큐(Queue)

## 1. 큐 구조

- 줄을 서는 행위와 유사
    - 가장 먼저 넣은 데이터를 가장 먼저 꺼낼 수 있는 구조

```bash
- FIFO (First-in, First-Out) 또는 LILO(Last-In, Last-Out)방식으로 스택과 꺼내는 순서가 반대
- 멀티 태스킹을 위한 스케줄링 방식을 구현하기 위해 많이 사용
```

[https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbhvAPe%2FbtqHlVqf0RY%2FY4oCoA4wUkEpvIkU80i43K%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbhvAPe%2FbtqHlVqf0RY%2FY4oCoA4wUkEpvIkU80i43K%2Fimg.png)

## 2.  큐의 연산

- 다른 한 쪽 끝은 리어(rear)로 정하여 삽입 연산만 수행함
- 큐는 한 쪽 끝은 프런트(front)로 정하여 삭제 연산만 수행함

## 3. 구현

```
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

```

## 우선 순위 큐 (Priority Queue)

- 높은 우선순위의 요소를 먼저 꺼내서 처리하는 구조
- 내부요소는 힙으로 구성되어 이진트리 구조
- 시간복잡도 O(NlogN)
- 우선순위 중요시 처리되어야 할때 사용

```java
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
```