package code.test.datastructure;

import java.util.Stack;

/*
 * JAVA - 그래프 구현
 * */
public class GraphArray {


    /* 인접 행렬 */
    private int[][] array;

    public GraphArray(int size) {
        //array = new int[size][size];

        /* 정점의 숫자와 같은 index 에 위치*/
        array = new int[size + 1][size + 1];
    }

    public int[][] getArray() {
        return array;
    }

    public boolean isEmpty() {
        return array == null;
    }

    /* 단방향 연결
     *   1 : 연결
     *   0 : 비연결
     * */
    public void addDiretedEdge(int x, int y) {
        array[x][y] = 1;
    }

    public void removeDiretedEdge(int x, int y) {
        array[x][y] = 0;
    }

    public void addCompleteEdge(int x, int y) {
        array[x][y] = 1;
        array[y][x] = 1;
    }

    public void removeCompleteEdge(int x, int y) {
        array[x][y] = 0;
        array[y][x] = 0;
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void dfsStack(int[][] graph) {
        boolean[] vistied = new boolean[9];
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        // 시작노드는 방문처리
        vistied[1] = true;

        while (!stack.isEmpty()) {
            System.out.println(stack);
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

    public static void main(String[] args) {

        GraphArray array = new GraphArray(5);

        array.addCompleteEdge(1, 2);
        array.addCompleteEdge(1, 3);
        array.addDiretedEdge(1,5);

        array.addCompleteEdge(3, 4);
        array.addCompleteEdge(3, 5);

        array.print();

        /*
        0 0 0 0 0 0
        0 0 1 1 0 1
        0 1 0 0 0 0
        0 1 0 0 1 1
        0 0 0 1 0 0
        0 0 0 1 0 0
         */
    }
}
