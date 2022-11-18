package code.test.programmers;

import java.util.*;

/*
 * [프로그래머스] - 가장 먼 노드
 * */
public class lessons49189 {

    static boolean[] vistied;

    public static void main(String[] args) {
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int n = 6;


        System.out.println(solution(n, edge));
    }

    static int solution(int n, int[][] edge) {
        vistied = new boolean[n];

        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        set.add(1);

        int cnt = 1;

        while (!queue.isEmpty()) {
            cnt = queue.size();

            for (int i = 0; i < cnt; i++) {
                int peek = queue.poll();

                for (int j = 0; j < edge.length; j++) {
                    if (edge[j][0] == peek && !set.contains(edge[j][1])) {
                        set.add(edge[j][1]);
                        queue.add(edge[j][1]);
                    }
                    if (edge[j][1] == peek && !set.contains(edge[j][0])) {
                        set.add(edge[j][0]);
                        queue.add(edge[j][0]);
                    }
                }
            }
        }

        return cnt;

    }

}
