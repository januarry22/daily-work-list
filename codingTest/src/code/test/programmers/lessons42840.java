package code.test.programmers;

import java.util.*;

/*
* [프로그래머스] - 모의고사 (완전탐색)
* */
public class lessons42840 {
    public static int[] answer= {1, 2, 3, 4, 5};
    public static int[] a= {1, 2, 3, 4, 5};
    public static int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
    public static int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public static void main(String[] args){
        int result[] = solution(answer, b);

        Arrays.stream(result).forEach(n -> System.out.println(n));
    }

    public static int[] solution( int[] answer,int[] user) {

        int correntCnt=0;
        for(int i =0; i<answer.length; i++){
            if(answer[i]==user[i % user.length]){
                correntCnt ++;
            }
        }
        List correntGrade = new ArrayList();
        correntGrade.add(correntCnt);

        Collections.sort(correntGrade);

        int[] result = correntGrade.stream().mapToInt(i-> (int) i).toArray();


        return result;
    }

}
