package code.test.programmers;

import java.util.Arrays;

/*
 * [프로그래머스] - 땅따먹기
 * */
public class lessons12913 {
    public static void main(String[] args) {
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};


        int answer =0;
        for(int i=1; i<land.length; i++){
            land[i][0] += Math.max(land[i-1][1],Math.max(land[i-1][2],land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0],Math.max(land[i-1][2],land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0],Math.max(land[i-1][1],land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0],Math.max(land[i-1][1],land[i-1][2]));
        }
        for(int i=0; i<4; i++){
            answer = Math.max(answer,land[land.length-1][i]);
        }
//        for(int i=0; i<land.length; i++){
//            int max = land[i][0];
//
//            for(int j=0; j<4; j++) {
//                System.out.println("index"+flag);
//                System.out.println(j);
//                if(max<land[i][j] && flag != j){
//                    max = land[i][j];
//                    flag = j-1;
//                }
//            }
//            sum+= max;
//        }


    }

}
