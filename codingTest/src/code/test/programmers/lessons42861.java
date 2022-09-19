package code.test.programmers;

import java.util.ArrayList;

/*
 * [프로그래머스] - 섬 연결하기
 * */
public class lessons42861 {
    public static boolean[] visited;
    public static ArrayList<Integer>[] graph;


    public static void main(String[] args) {
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        int n = 4;

        System.out.println(solution(n, costs));
    }

    public static int solution(int n, int[][] costs) {

        visited = new boolean[n];


        /* union-find 알고리즘 사용 */
        for(int[] spot : costs){
           int start = spot[0];
           int end = spot[1];
           int cost = spot[2];

        }

        return 0;
    }

}
