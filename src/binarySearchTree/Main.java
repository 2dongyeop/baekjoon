package binarySearchTree;

import java.util.Scanner;

class Node {
    private int data;
    private Node lNode;
    private Node rNode;

    public int getData() {
        return data;
    }

    public Node getlNode() {
        return lNode;
    }

    public Node getrNode() {
        return rNode;
    }

    public void setlNode(Node node) {
        this.lNode = node;
    }

    public void setrNode(Node node) {
        this.rNode = node;
    }

    Node(int data) {
        this.data = data;
    }
}

class Tree {
    Node root;

    public void createNode(int data) {
        if (root == null) {
            root = new Node(data);
            //root.lNode = null; root.rNode = null;
        } else {
            traversalNode(root, data);
        }
    }

    public void traversalNode(Node node, int data) {
        if (node.getData() > data) {
            if (node.getrNode() == null) {
                node.setrNode(new Node(data));
            } else {
                traversalNode(node.getrNode(), data);
            }
        } else {
            if (node.getlNode() == null) {
                node.setlNode(new Node(data));
            } else {
                traversalNode(node.getlNode(), data);
            }
        }
    }

    public void postOrderTraversal(Node node) {
        if (node != null) {
            if (node.getlNode() != null) postOrderTraversal(node.getlNode());
            if (node.getrNode() != null) postOrderTraversal(node.getrNode());
            System.out.println(node.getData());
        }
    }
}

public class Main {
    final static int SIZE = 9;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Tree tree = new Tree();

        System.out.println("전위 순회 방식으로 정렬한 노드들의 데이터를 입력합니다.");
        try {
            for (int i = 0; i < SIZE; i++) {
                String data = scanner.next();

                tree.createNode(Integer.parseInt(data));
            }
        } catch (NullPointerException e) {
            System.err.println("NullPointerException 발생");
        }

        tree.postOrderTraversal(tree.root);
    }
}
