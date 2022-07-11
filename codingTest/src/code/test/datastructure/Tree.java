package code.test.datastructure;

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
