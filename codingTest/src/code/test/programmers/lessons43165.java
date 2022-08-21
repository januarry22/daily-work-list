package code.test.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * [프로그래머스] - 타겟 넘버
 * */
public class lessons43165 {
    public static boolean[] visit;
    public static int[] numbers = {1, 1, 1, 1, 1};

    public static void main(String[] args) {

    }


    public static void dfs(int depth, String now, String path, String[][] tickets) {


        for (int i = 0; i < tickets.length; i++) {
            if (!visit[i] && now.equals(tickets[i][0])) {
                visit[i] = true;
                dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visit[i] = false;
            }
        }
    }


}
