# 이진 탐색 (Binary Search)

# 트리 (Tree)

## 1. 트리(Tree)

- 트리 : Node와 Branch를 이용해서, 사이클을 이루지 않도록 구성한 데이터 구조
- 트리 중 이진 트리(Binary Tree)형태의 구조로, 탐색(검색) 알고리즘 구현을 위해 많이 사용됨

## 2. 용어

- Node : 트리에서 데이터를 저장하는 기본 요소(데이터와 다른 연결된 노드에 대한 Branch 정보 포함)
- Root Node : 트리 맨 위에 있는 노드
- Level : 최상위 노드를 Level 0 으로 하였을 때, 하위 Branch 로 연결된 노드의 길이를 나타냄
- Parent Node : 어떤 노드의 다음 레벨에 연결된 노드
- Child Node : 어떤 노드의 상위 레벨에 연결된 노드
- Leaf Node (Termianl Node) : Child Node가 하나도 없는 노드
- Sibling (Brother Node) : 동일한 Parent Node를 가진 노드
- Depth : 트리에서 Node가 가질 수 있는 최대 Level

## 3. 이진 트리와 이진 탐색 트리(Binary Search Tree)

- 이진 트리 : 노드의 최대 Branch가 2인 트리
- 이진 탐색 트리 (Binary Search Tree, BST) : 이진 트리에 다음과 같은 추가적인 조건이 있는 트리
    - 왼쪽 노드는 해당 노드보다 작은 값, 오른쪽 노드는 해당 노드보다 큰 값을 가지고 있음
    
    ![https://gmlwjd9405.github.io/images/data-structure-tree/tree-terms.png](https://gmlwjd9405.github.io/images/data-structure-tree/tree-terms.png)
    

## 4. 자료구조 이진 탐색 트리의 장점과 용도

- 용도 : 데이터 검색(탐색)
- 장점 : 탐색 속도를 개선할 수 있음

### 이진트리와 정렬된 배열간의 탐색 비교

![https://blog.penjee.com/wp-content/uploads/2015/11/binary-search-tree-sorted-array-animation.gif](https://blog.penjee.com/wp-content/uploads/2015/11/binary-search-tree-sorted-array-animation.gif)