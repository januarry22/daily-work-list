# 그래프(Graph)

# 1. 그래프 (Graph) ?

- 정점(vertex) 와 간선(Edge)로 이루어져 있음
- 간선은 정점간의 관계를 나타내는데 사용
- G = (V,E)

# 2. 그래프 구현

### 인접 행렬과 연결리스트로 구현

- 인접 행렬
    - 2차원 행렬이 필요

```java

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

    public static void main(String[] args) {

        GraphArray array = new GraphArray(5);

        array.addCompleteEdge(1, 2);
        array.addCompleteEdge(1, 3);
				array.addDiretedEdge(1,5);

        array.addCompleteEdge(3, 4);
        array.addCompleteEdge(3, 5);

        array.print();
    }

}
```

```java
/*
        0 0 0 0 0 0 
        0 0 1 1 0 1 
        0 1 0 0 0 0 
        0 1 0 0 1 1 
        0 0 0 1 0 0 
        0 0 0 1 0 0
*/

1 -> 2, 3, 5
2 -> 1
3 -> 1, 4, 5
4 -> 3
5 -> 3

으로 연결된 형태를 확인

```

- 연결리스트
    - ArrayList 사용

```java

import java.util.ArrayList;

/*
 * JAVA - 그래프 구현
 * */
public class GraphLinkedList {

    /* 연결리스트  */
    private ArrayList<ArrayList<Integer>> listGraph;

    public GraphLinkedList(int size) {
        listGraph = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<size +1; i++){
            listGraph.add(new ArrayList<Integer>());
        }
    }

    public ArrayList<ArrayList<Integer>> getArray() {
        return listGraph;
    }
		/* 연결리스트로 정점 (vertex) 추가 */
    public void addVertex(int x){
        listGraph.add(new ArrayList<Integer>());
    }

    /* 단방향 연결
     *   x -> y
     * */
    public void addDiretedEdge(int x, int y) {
       listGraph.get(x).add(y);
    }

    /* 양방향 연결
    * x <-> y
    * */
    public void addCompleteEdge(int x, int y) {
        listGraph.get(x).add(y);
        listGraph.get(y).add(x);
    }

    public void print() {
        for (int i = 1; i < listGraph.size(); i++) {
            System.out.print("vertex -> ");
            for (int j = 0; j < listGraph.get(i).size(); j++) {
                System.out.print(" "+listGraph.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        GraphLinkedList graph = new GraphLinkedList(5);
			
				graph.addVertex(6);

        graph.addCompleteEdge(1, 2);
        graph.addCompleteEdge(1, 3);
        graph.addDiretedEdge(1,5);

        graph.addCompleteEdge(3, 4);
        graph.addCompleteEdge(3, 5);

        graph.print();

    }

}
```

```java
정점(vertex) 1->  2 3 5
정점(vertex) 2->  1
정점(vertex) 3->  1 4 5
정점(vertex) 4->  3
정점(vertex) 5->  3
정점(vertex) 6->

- 간선이 연결된 형태를 확인
```

<aside>
💡 연결리스트는 정점(vertex) 의 추가/삭제가 빈번할때 용이하고, 
인접행렬은 간선(Edge)의 변경이 있 사용

</aside>