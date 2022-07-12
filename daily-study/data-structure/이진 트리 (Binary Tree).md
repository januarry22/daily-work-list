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

		/* 그래프 값을 비교한 뒤 순회하면서 left, right를 채워나감 */
    public void push(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
	   }

        Node currentNode= root;
        while (true) {
            // root 보다 data 가 작을 경우
            if (data < currentNode.data) {
                // root의 left 가 빈값이 아닐때
                if (currentNode.left != null) {
                    // 노드를 가리키는 위치를 left 자리로 옮김
                    currentNode = currentNode.left;
                } else {
                    // null 이면 data 를 left에 넣음
                    currentNode.left = newNode;
                    break;
                }
            } else {
                // root 보다 data 가 클 경우
                // right 노드가 비어 있지 않을 경
                if (currentNode.right != null) {
                    currentNode = currentNode.right;
                } else {
                    // 비어 있으면 right 에 넣음
                    currentNode.right = newNode;
                    break;
                }
            }
        }
    }

    public boolean search(int data) {
        Node currentNode = root;

        while (true) {
            if (currentNode.data == data) {
                return true;
            } else if (data < currentNode.data) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
    }
		/* 재귀를 이용해서 추가 */
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
- 자식노드**가 없는 경우**
    - 삭제할 Node의 Parent Node가 삭제할 Child Node를 가리키지 않도록 한다.
- 자식 노드가 **(left or right) 한개인 경우**
    - 삭제할 노드의 자식노드를 (left, right) 에 따라 Parent Node가 가리키도록 한다.
- 자식노드**가 두개인 경우**
    
     1. 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 삭제할 Node의 Parent Node가 가리키도록 한다.
    
    1. 삭제할 Node의 왼쪽 자식 중, 가장 큰 값을 삭제할 Node의 Parent Node가 가리키도록 한다.

```java
public boolean pop(int data) {
        Node removeNode = root;
        Node removeParent = null;

        // root 가 삭제할 data 가 아니면
        while (removeNode.data != data) {
            // 현재 노드의 부모 노드로
            removeParent = removeNode;

            // 삭제할 값이 현재 값 보다 작으면
            if (removeNode.data > data) {
                // 현재 노드의 왼쪽을 가리킴
                removeNode = removeNode.left;
            } else {
                removeNode = removeNode.right;
            }
        }
        // leaf 노드 (단말 노드) 인경우
        if (removeNode == null) {
            return false;
        }

        /* 자식 노드가 없을 때 */
        if (removeNode.left == null && removeNode.right == null) {
            // root 이면 null
            if (removeNode == root) {
                root = null;
            } else if (removeNode == removeParent.right) {
                removeParent.right = null;
            } else {
                removeParent.left = null;
            }
        }

        /* right 노드만 존재 할 경우 */
        else if (removeNode.left == null) {
            if (removeNode == root) {
                root = removeNode.right;
            } else if (removeNode == removeParent.right) {
                removeParent.right = removeNode.right;
            } else {
                removeParent.left = removeNode.left;
            }
        }

        /* left 노드만 존재 할 경우 */
        else if (removeNode.right == null) {
            if (removeNode == root) {
                root = removeNode.left;
            } else if (removeNode == removeParent.right) {
                removeParent = removeNode.right;
            } else {
                removeParent = removeNode.left;
            }
        }

        /* 두개의 자식 노드가 존재하는 경우 */

        else {
            Node parentReplace = removeNode;

            Node replaceNode = parentReplace.right;

            while (replaceNode.left != null) {
                parentReplace = replaceNode;
                replaceNode = replaceNode.left;
            }

            if (replaceNode != removeNode.right) {
                parentReplace.left = replaceNode.right;
                replaceNode.right = removeNode.right;
            }

            if (removeNode == root) {
                root = removeNode;
            } else if (removeNode == removeParent.right) {
                removeParent.right = replaceNode;
            } else {
                removeParent.left = replaceNode;
            }

            replaceNode.left = removeNode.left;

        }
        return true;
    }
```

# 3. 이진 트리 특징

- 데이터 검색(탐색) 속도 개선
- 노드의 개수 : N
- 시간 복잡도 : O(logN)