# 이진 트리 (Binary Tree)

# 1. 이진 트리 (Binary Tree) ?

- 각각의 노드가 최대 2명의 자식을 가지는 트리
- 자식노드는 항상 left , right 값을 가짐
    - 왼쪽 노드는 해당 노드보다 작은 값, 오른쪽 노드는 해당 노드보다 큰 값을 가지고 있음
- 두개의 트리에 같은 키 값을 가지는 자식노드가 있어도 해당 자식노드의 left , right 값이 다른 경우엔 다른 트리

# 2. 구현

```java

/*
 * JAVA - 이진 트리 구현
 * */
public class BinaryTree {

    Node root;

    public class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    public void addTree(int[] arr) {
        root = addTreeNode(arr, 0, arr.length - 1);
    }

    public Node addTreeNode(int[] tree, int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        Node node = new Node(tree[mid]);
        node.left = addTreeNode(tree, start, mid - 1);
        node.right = addTreeNode(tree, mid + 1, end);

        return node;
    }

		//이진 검색 : 중간값을 구해서 해당 중간값보다 크거나 작은지를 판단해서 왼쪽/오른쪽 노드 지정
    public void searchTree(Node node, int find) {

        if (find < node.data) {
            System.out.println("방문 노드 : " + node.data);
            searchTree(node.left, find);
        } else if (find > node.data) {
            System.out.println("방문 노드 : " + node.data);
            searchTree(node.right, find);
        } else {
            System.out.println("Find");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = i;
        }
        tree.addTree(a);
        tree.searchTree(tree.root, 9);

    }

}
```

### 이진 탐색 트리 삭제

- **Leaf Node 삭제**
    - 삭제할 Node의 Parent Node가 삭제할 Node를 가리키지 않도록 한다.
- **Child Node가 하나면삭제**
    - 삭제할 Node의 Parent Node가 삭제할 Child Node를 가리키지 않도록 한다.
    1. 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 삭제할 Node의 Parent Node가 가리키도록 한다.
    2. 삭제할 Node의 왼쪽 자식 중, 가장 큰 값을 삭제할 Node의 Parent Node가 가리키도록 한다.

# 3. 이진 트리 특징

- 데이터 검색(탐색) 속도 개선
- 노드의 개수 : N
- 시간 복잡도 : O(logN)