package code.test.programmers;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * [프로그래머스] - 양과 늑대
 * */
public class lessons92343 {
    public static ArrayList<Integer>[] graph;
    public static boolean[][][] visited;
    public static int[] infos;
    public static int answer = 1;

    public static void main(String[] args) {
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};


        System.out.println(solution(info, edges));

    }

    public static int solution(int[] info, int[][] edges) {

        graph = new ArrayList[info.length];

        for (int i = 0; i < info.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];

            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        visited = new boolean[info.length][info.length + 1][info.length + 1];

        infos = info;

        visited[0][0][0] = true;

        dfs(0, 0, 0);

        return answer;
    }

    public static void dfs(int idx, int sheep, int wolf) {
        int temp = -1;

        if (infos[idx] != -1) {
            if (infos[idx] == 0) {
                temp = 0;
                sheep++;
            } else {
                temp = 1;
                wolf++;
            }
        }


        if (sheep <= wolf) {
            return;
        } else {
            answer = Math.max(answer, sheep);
        }

        for (int i = 0; i < graph[idx].size(); i++) {
            int next = graph[idx].get(i);

            if (visited[next][sheep][wolf] == true) {
                continue;
            }

            infos[idx] = -1;

            visited[idx][sheep][wolf] = true;

            dfs(next, sheep, wolf);

            infos[idx] = temp;
            visited[idx][sheep][wolf] = false;
        }
    }
}
