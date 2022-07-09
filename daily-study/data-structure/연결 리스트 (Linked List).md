# 연결 리스트 (Linked List)

# **연결 리스트 (Linked List)**

## **1. 연결 리스트 (Linked List) 구조**

- 노드가 데이터와 포인터를 가지고 한 줄로 연결되어 있는 방식
- 각 데이터는 노드라 불리며 배열에서 자주 삽입, 삭제가 이루어지는 경우 용이
    - ArrayList보다 검색의 경우에 있어서 느림
- 연결 리스트 기본 구조
    - 노드 (Node) : 데이터 저장 단위 (데이터값, 포인터)로 구성
    - 포인터(pointer) : 각 노드 안에서, 다음이나 이전의 노드와의 연결 정보를 가지고 있는 공간
    
    [https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbygm8v%2Fbtq5lxMb2f7%2FUookpU9dnl1uKNZs6i4Bu0%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbygm8v%2Fbtq5lxMb2f7%2FUookpU9dnl1uKNZs6i4Bu0%2Fimg.png)
    

## 2. 연결 리스트의 장단점

- 장점
    - 미리 데이터 공간을 할당 하지 않아도 됨
    - 배열은 미리 데이터 공간을 할당 해야함
- 단점
    - 연결을 위한 별도 데이터 공간이 필요하며, 저장공간 효율이 높지 않음
    - 연결 정보를 찾는 시가닝 필요하므로 접근 속도가 느림
    - 중간 데이터 삭제시, 앞뒤 데이터의 연결을 재구성해야 하는 부가적인 작업 필요
    

## 3. 구현

```jsx

import java.util.Iterator;
import java.util.LinkedList;

/*
* JAVA 배열
* */
public class linkedList {
    public static void main(String[] args){
        // 타입 미설정시 object 로 세팅됨
        LinkedList<String> linkedList = new LinkedList();

        // 리스트 추가
        linkedList.add("item1");
        linkedList.add("item2");
        linkedList.add("item3");

        linkedList.addFirst("first");
        // 첫번째 인덱스에 추가
        linkedList.addLast("last");
        // 마지막 인덱스에 추가

        // for 문으로 출
        for(String a :linkedList){
            System.out.println(a);
        }

        // Iterator 클래스로도 출력 가능
        Iterator<String> iter = linkedList.iterator(); //Iterator 선언
        while(iter.hasNext()){//다음값이 있는지 체크
            System.out.println(iter.next()); //값 출력
        }

        linkedList.remove(1);
        // 삭제
        linkedList.clear();
        // 모든 값 제거
    }

}
```