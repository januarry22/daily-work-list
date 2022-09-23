package code.test.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * JAVA DFS
 *
 * */
public class DFS {

    // 인덱스가 각각의 노드번호가 될 수 있게 0번인덱스는 아무것도 없는 상태
    static int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};

    public static void main(String[] args) {
        System.out.println("[재귀 함수]");
        dfs(1);
        System.out.println();
        System.out.println("[스택]");
        dfsStack(graph);
    }

    // 방문처리에 사용 할 배열선언
    static boolean[] vistied = new boolean[9];
    /* 재귀 함수로 구현 */
    static void dfs(int index) {


        // 시작노드는 방문처리
        vistied[index] = true;

        System.out.print( index + "->");

        for (int node : graph[index]) {
            if (!vistied[node]) {
                dfs(node);
            }
        }

    }

    /* 스택으로 구현 */
    static void dfsStack(int[][] graph) {
        boolean[] vistied = new boolean[9];
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        // 시작노드는 방문처리
        vistied[1] = true;

        while (!stack.isEmpty()) {
            int index = stack.pop();
            System.out.print(index + "->");
            for (int linked : graph[index]) {
                // 방문처리
                if (!vistied[linked]) {
                    stack.push(linked);
                    vistied[linked] = true;
                }
            }
        }

    }
}
