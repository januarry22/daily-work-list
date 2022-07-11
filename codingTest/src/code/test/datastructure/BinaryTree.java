package code.test.datastructure;

/*
 * JAVA - 트리 구현
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
