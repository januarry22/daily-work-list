package code.test.programmers;

import java.util.Arrays;

/*
* [프로그래머스] - 최소직사각형
* */
public class lessons86491 {
    public static int budget = 10;
    public static int[][] sizes={{60, 50}, {30, 70}, {60, 30}, {80, 40}};

    public static void main(String[] args){
        int answer = solution(sizes);
        System.out.println("answer"+answer);
    }

    public static int solution(int[][] sizes) {
        int answer=0;

        for(int i =0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[0][i]){

            }
        }

        return answer;
    }

}
