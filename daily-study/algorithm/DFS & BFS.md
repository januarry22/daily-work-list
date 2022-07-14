# DFS & BFS

## 1. BFS 와 DFS 란?

- 대표적인 그래프 탐색 알고리즘
    - 너비 우선 탐색(Breadth-First Search)
    : 정점들과 같은 레벨에 있는 노드들 (형제 노드들)을 먼저 탐색하는 방식
    - 깊이 우선 탐색(Depth-First Search)
    : 정점의 자식들을 먼저 탐색하는 방식

### 예제

```
- BFS 방식: A - B - C - D - G - H - I - E - F - J
  - 한 단계씩 내려가면서, 해당 노드와 같은 레벨에 있는 노드들 (형제 노드들)을 먼저 순회함
- DFS 방식: A - B - D - E - F - C - G - H - I - J
  - 한 노드의 자식을 타고 끝까지 순회한 후, 다시 돌아와서 다른 형제들의 자식을 타고 내려가며 순회함

```

![https://www.fun-coding.org/00_Images/BFSDFS.png](https://www.fun-coding.org/00_Images/BFSDFS.png)

## 2. 너비 우선 탐색 (Breadth-First Search)

### BFS 알고리즘 구현

- 큐를 사용해서 구현
- 루트 노드 또는 임의 노드에서 **인접한 노드부터 먼저 탐색**하는 방법
- 최소 비용에 적합

```bash

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
```

### BFS 시간 복잡도

- 일반적인 BFS 시간 복잡도
    - 노드수 : V
    - 간선수 : E
    - 시간복잡도 :
        - 인접 행렬 : O(V^2)
        - 인접 리스트 : O(V +E)

## 3. 깊이 우선 탐색 (Depth-First Search)

### DFS 알고리즘 구현

- 스택 이나 재귀함수로 구현
- 모든 경로를 방문해야 할 경우 사용에 적합

### DFS 시간 복잡도

- 일반적인 BFS 시간 복잡도
    - 노드수 : V
    - 간선수 : E
    - 시간복잡도 :
        - 인접 행렬 : O(V^2)
        - 인접 리스트 : O(V +E)