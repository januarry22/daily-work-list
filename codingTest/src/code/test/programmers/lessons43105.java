package code.test.programmers;

import java.util.*;
import java.util.stream.StreamSupport;

/*
 * [프로그래머스] - 정수 삼각형
 * */
public class lessons43105 {

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }

    public static int solution(int[][] triangle) {

        int N = triangle.length;
        if (N == 1) {
            return triangle[0][0];
        }

        for(int i=N-2; i>=0; i--){
            for(int j=0; j<i+1; j++){
                triangle[i][j]  += Math.max(triangle[i+1][j],triangle[i+1][j+1]);
      //          System.out.println(Math.max(triangle[i+1][j],triangle[i+1][j+1]));
            }
        }
        return triangle[0][0];
    }

}
