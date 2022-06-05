package binarySearchTree;

import java.util.Scanner;

class Node {
    private int data;
    Node lNode;
    Node rNode;

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }

    Node(int data) { this.data = data;}
}

class Tree {
    Node root;

    public void createNode(int data) {
        if (root == null) {
            root.setData(data);
            root.lNode = null; root.rNode = null;
        } else {
            goToSeat(root, data);
        }
    }

    public void goToSeat(Node node, int data) {
        if (node.getData() > data) {
            if (node.rNode == null) {
                node.rNode = new Node(data);
            } else {
                goToSeat(node.rNode, data);
            }
        } else {
            if (node.lNode == null) {
                node.lNode = new Node(data);
            } else {
                goToSeat(node.lNode, data);
            }
        }
    }

    public void postOrderTraversal(Node node){
        if (node != null) {
            System.out.println(node.getData());
            if (node.lNode != null) postOrderTraversal(node.lNode);
            if (node.rNode != null) postOrderTraversal(node.rNode);
        }
    }
}

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Tree tree = new Tree();
        final int SIZE = 9;

        System.out.println("전위 순회 방식으로 정렬한 노드들의 데이터를 입력합니다.");
        for (int i = 0; i < SIZE; i++) {
            int data = scanner.nextInt();

            tree.createNode(data);
        }

        tree.postOrderTraversal(tree.root);
    }
}
