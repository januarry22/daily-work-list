package code.test.programmers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * [프로그래머스] - 퍼즐 조각 채우기
 * */
public class lessons84021 {

    static boolean[] vistied;

    public static void main(String[] args) {
        int[][] game_board = {{0, 0, 0}, {1, 1, 0}, {1, 1, 1}};
        int[][] table = {{1, 1, 1}, {1, 0, 0}, {0, 0, 0}};

        System.out.println(solution(game_board , table));
    }

    static int solution(int[][] game_board, int[][] table) {

        int a = game_board.length;
        for(int[] arr : game_board){

            for(int b : arr){

                System.out.println(b);
                System.out.println(b);
                System.out.println(b);
                System.out.println(b);
                System.out.println(b);
                System.out.println(b);
            }


        }


        return 1;

    }

}
