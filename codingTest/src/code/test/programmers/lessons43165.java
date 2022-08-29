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

        dfs(0, "ICN", "ICN", numbers);

    }


    public static void dfs(int depth, String now, String path, int[] tickets) {

        if (depth == tickets.length) {
            list.add(path);
            return;
        }

    }


}
