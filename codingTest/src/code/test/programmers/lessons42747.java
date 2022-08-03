package code.test.programmers;

import java.util.Arrays;

/*
* [프로그래머스] - H-index
 * */
public class lessons42747 {

    public static void main(String[] args){
        int answer = 0;
        int[]citations = {3, 0, 6, 1, 5};
        Arrays.sort(citations);

        // j 번이상 인용된 논문이 j개 있는지
        for(int i=0; i<citations.length; i++){
            int h = citations.length-i;
            if(citations[i]>=h){
                answer = h;
                break;
            }
        }
        System.out.println(answer);
    }

}
