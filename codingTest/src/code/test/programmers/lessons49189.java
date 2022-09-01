package code.test.programmers;

import java.util.Arrays;
import java.util.Stack;

/*
* [프로그래머스] - 가장 먼 노드
 * */
public class lessons49189 {

    static boolean[] vistied = new boolean[6];
    public static int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
    public static int n = 6;


    public static void main(String[] args){

        dfs(1);
    }

    static void dfs(int index) {

        // 시작노드는 방문처리
        vistied[index] = true;

        System.out.print( index + "->");

//        for (int node : vertex[index]) {
//            if (!vistied[node]) {
//                dfs(node);
//            }
//        }

    }

}
