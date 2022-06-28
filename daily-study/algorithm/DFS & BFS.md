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

```bash

```

### BFS 시간 복잡도

- 일반적인 BFS 시간 복잡도
    - 노드수 : V
    - 간선수 : E
    - 시간복잡도 : O(V +E)

## 3. 깊이 우선 탐색 (Depth-First Search)

### DFS 시간 복잡도

- 일반적인 BFS 시간 복잡도
    - 노드수 : V
    - 간선수 : E
    - 시간복잡도 : O(V +E)