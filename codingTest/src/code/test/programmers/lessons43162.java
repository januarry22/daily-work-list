package code.test.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * [프로그래머스] - 네트워크
 * */
public class lessons43162 {

    static int visit[];
    static int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

    public static void main(String[] args) {
        int answer = 0;
        int n = 3;
        visit = new int[n];

//        for (int i = 0; i < n; i++) {
//            if (visit[i] == 0) {
//                answer++;
//                bfs(n, i, computers);
//            }
//        }

        System.out.println(answer);
        for (int i = 0; i < n; i++) {
            if (visit[i] == 0) {
                answer++;
                dfs(i);
            }
        }

    }

    public static void bfs(int n, int node, int[][] computers) {
        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(node);

        visit[node] = 1;

        while (!queue.isEmpty()) {
            int index = queue.poll();

            for (int i = 0; i < n; i++) {
                if (computers[index][i] == 1 && visit[i] == 0) {
                    queue.add(i);
                    visit[i] = 1;
                }
            }

        }
    }


    public static void dfs( int index) {
        visit[index] = 1;

        for(int node : computers[index]){
            if(visit[node]==0){
                dfs(node);
            }
        }
    }

}
