# 트리 (Tree)

# 1. 트리 (Tree) ?

- 비선형 자료구조 이며 계층적 구조 형태
- 노드가 N개인 트리는 항상 N-1개의 간선(edge)을 가진다
- 두개의 정점 사이에 단 1개의 경로만을 가짐
- 한 개의 루트노드(Root) 만 존재, 모든 자식 노드는 한개의 부모 노드를 가짐

# 2. 트리 관련 용어

![https://gmlwjd9405.github.io/images/data-structure-tree/tree-terms.png](https://gmlwjd9405.github.io/images/data-structure-tree/tree-terms.png)

### - 명칭

- 루트(root) : 트리 구조 중 최상위에 존재하는 노드
- 노드(node) : 트리에서 각각의 구성 요소

### -  관계

- 형제 노드(sibling) : 같은 레벨의 노드
- 부모 노드(parent node) : 한 노드를 기준으로 바로 상위에 존재하는 노드
- 자식 노드(child node) : 한 노드를 기준으로 바로 하위에 존재하는 노드
- 리트(leaf)노드 : 자식이 없는 노드

### - 기타

- 레벨(level) : 트리에서 각각의 층을 나타내는 단어(루트 노드는 0)
- 높이(heigh) : 트리 중 최고 레벨
- 간선(edge) : 노드와 노드를 연결하는 선

# 3. 트리 생성 과정

**1. 데이터와 연결 상태를 저장할 공간(=노드) 생성**

- 각각의 노드는 데이터, left, right 자식 노드 값을 가짐

**2. 각각의 노드들에 값 저장**

**3. 노드 간 연결 상태 정의**

```java

/*
* JAVA - 트리 구현
* */
public class Tree {
    int count = 0;

    public Tree(){
        count = 0;
    }
    public class Node {
        Object data;
        Node left;
        Node right;

        public Node(Object data){
            this.data = data;
            left = null;
            right = null;
        }

        public void addLeft(Node node) {
            left = node;
            count++;
        }

        public void addRight(Node node) {
            right = node;
            count++;
        }

        public void deleteLeft() {
            left = null;
            count--;
        }

        public void deleteRight() {
            right = null;
            count--;
        }
    }

    public Node addNode(Object data) {
        Node n = new Node(data);
        return n;
    }

		
    public void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(Node node) {
        if(node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args){
        Tree tree = new Tree();

        Node node1 =  tree.addNode("a");
        Node node2 = tree.addNode("b");
        Node node3 = tree.addNode("c");
        Node node4 = tree.addNode("d");
        Node node5 = tree.addNode("e");

        // tree 형태
        /*
                a
             b     c
          d    e
        * */
        // 생성된 노드에 연결 정보 추가
        node1.addLeft(node2);
        node1.addRight(node3);
        node2.addLeft(node4);
        node2.addRight(node5);

        // pre-order (전위 순회) : a - b - d - e - c
        tree.preOrder(node1);
        System.out.println();
        // a b d e c

        // post-order (후위 순회) : d - e - b - c - a
        tree.postOrder(node1);
        System.out.println();
        // d e b c a

        // node2의 왼쪽 자식 노드 삭제 -> d 삭제
        /* 트리 형태 
                a
             b     c
               e
        * */
        node2.deleteLeft();
        tree.preOrder(node1);
        // a b e c
    }

}
```

# 4. 트리 순회(traversal)

- **중순위(inorder)**
    - 왼쪽 서브트리 → 루트 → 오른쪽 서브트리
        - H → I → D → J → E → B → A → C → F → G
- **선순위(preorder)**
    - 루트 → 왼쪽 서브트리 → 오른쪽 서브트리
        - A → B → D → H → I → E → J → C → F → G
- **후순위(postorder)**
    - 왼쪽 서브트리 → 오른쪽 서브트리 → 루트
        - H → I → D → J → E → B → F → G → C → A
    - DFS
- **레벨오더(level order) 순회**
    - 레벨 0 부터 끝까지 순회
        - A → B → C → D → E → F → G → H → I → J
    - BFS