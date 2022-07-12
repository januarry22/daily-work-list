package code.test.datastructure;

import java.util.LinkedList;
import java.util.Queue;

/*
 * JAVA - 이진  트리 구현
 * */
public class BinaryTree {

    public class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    Node root;

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
           System.out.println(newNode.data);
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
    /**
     * 전위 순회
     */
    public void preorderTree(Node root, int depth) {
        if (root != null) {
            for (int i = 0; i < depth; i++) {
                System.out.print("ㄴ");
            }
            System.out.println(root.data);
            preorderTree(root.left, depth + 1);
            preorderTree(root.right, depth + 1);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] a = new int[10];

        tree.push(5);
        tree.push(8);
        tree.push(7);
        tree.push(10);
        tree.push(9);
        tree.push(11);

        tree.pop(10);
        tree.preorderTree(tree.root, 0);
    }

}
