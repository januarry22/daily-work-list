package code.test.programmers;

import java.util.*;

/*
* [프로그래머스] - 예산
* */
public class lessons12982 {
    public static int budget = 10;
    public static int[] d={2,2,3,3};

    public static void main(String[] args){
        int answer = solution(budget,d);
        System.out.println("answer"+answer);
    }

    public static int solution(int budget, int[] d) {
        int answer=0;

        Arrays.sort(d);

        for(int i : d){
            budget -= i;

            if(budget<0){
                break;
            }
            answer ++;
        }

        return answer;
    }

}
