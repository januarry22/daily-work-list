package code.test.datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

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
