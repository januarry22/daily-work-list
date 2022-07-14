package code.test.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * JAVA BFS
 *
 * */
public class BFS {
    // 방문처리에 사용 할 배열선언
    static boolean[] vistied = new boolean[9];

    // 인덱스가 각각의 노드번호가 될 수 있게 0번인덱스는 아무것도 없는 상태
    static int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};

    public static void main(String[] args) {
        bfs(1, graph, vistied);

        System.out.println( );
        System.out.println(Arrays.toString(vistied));
    //    System.out.println(Arrays.deepToString(graph));
    }

    static void bfs(int start, int[][] graph, boolean[] vistied) {


        // 큐를 이용해서 구현
        Queue<Integer> queue = new LinkedList<Integer>();
        // 시작할 노드번호
        queue.offer(start);

        // 시작노드는 방문처리
        vistied[start] = true;

        while (!queue.isEmpty()) {
            int index = queue.poll();
            for (int i = 0; i < graph[index].length; i++) {
                int temp = graph[index][i];

                // 방문처리
                if (!vistied[temp]) {
                    vistied[temp] = true;
                    queue.offer(temp);
                }
            }
            System.out.print( index + "->");
        }


    }
}
