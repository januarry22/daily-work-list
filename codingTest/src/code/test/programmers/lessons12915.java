package code.test.programmers;

import java.util.*;

/*
* [프로그래머스] - 문자열 내 마음대로 정렬하기
 * */
public class lessons12915 {
    public static int N = 1;
    public static String[] strings={"sun", "bed", "car"};

    public static void main(String[] args){
        String answer[] = solution( strings,N);

        Arrays.stream(answer).forEach(n -> System.out.println(n));
    }

    public static String[] solution(String[] strings, int N) {
        String answer[] = {};

        for(String str : strings){
            char getString = str.charAt(N);
            System.out.println(getString);
        }
       // Arrays.sort();


        return answer;
    }

}
