package treeTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Node {
    private char data;
    private Node leftNode;
    private Node rightNode;

    char getData() {
        return this.data;
    }

    Node getLeftNode() {
        return this.leftNode;
    }

    Node getRightNode() {
        return this.rightNode;
    }

    void setLeftNode(Node node) {
        this.leftNode = node;
    }

    void setRightNode(Node node) {
        this.rightNode = node;
    }

    Node(char data) {
        this.data = data;
    }
}

class Tree {
    public Node root;

    public void createNode(char data, char left, char right) {
        if (root == null) { //맨 처음 루트노드 생성 코드
            root = new Node(data);
            if (left == '.') {
                root.setLeftNode(null);
            } else {
                root.setLeftNode(new Node(left));
            }

            if (right == '.') {
                root.setRightNode(null);
            } else {
                root.setRightNode(new Node(right));
            }

        } else {
            recursiveNode(root, data, left, right); //루트가 있다면 재귀 방식으로 해당 위치 이동
        }
    }

    public void recursiveNode(Node node, char data, char left, char right) {
        if (node == null) { //말단일 경우 여기로 들어와서 return됨
            return;
        } else if (node.getData() == data) {
            if (left == '.') {
                node.setLeftNode(null);
            } else {
                node.setLeftNode(new Node(left));
            }

            if (right == '.') {
                node.setRightNode(null);
            } else {
                node.setRightNode(new Node(right));
            }
        } else { //해당 위치로 이동할 때까지 재귀 호출
            recursiveNode(node.getLeftNode(), data, left, right);
            recursiveNode(node.getRightNode(), data, left, right);
        }
    }

    public void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.getData());
            if (node.getLeftNode() != null) preOrderTraversal(node.getLeftNode());
            if (node.getRightNode() != null) preOrderTraversal(node.getRightNode());
        }
    }

    public void inOrderTraversal(Node node) {
        if (node != null) {
            if (node.getLeftNode() != null) inOrderTraversal(node.getLeftNode());
            System.out.print(node.getData());
            if (node.getRightNode() != null) inOrderTraversal(node.getRightNode());
        }
    }

    public void postOrderTraversal(Node node) {
        if (node != null) {
            if (node.getLeftNode() != null) postOrderTraversal(node.getLeftNode());
            if (node.getRightNode() != null) postOrderTraversal(node.getRightNode());
            System.out.print(node.getData());
        }
    }
}

public class Main {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Tree tree = new Tree();

        System.out.print("생성할 노드 갯수를 입력하세요 > ");
        int nodeCount = Integer.parseInt(String.valueOf(bufferedReader.readLine()));

        for (int i = 0; i < nodeCount; i++) {
            System.out.print((i + 1) + "번째 노드 이름, 왼쪽 자식 노드, 오른쪽 자식 노드를 순서대로 입력하세요 > ");
            String str = bufferedReader.readLine();

            StringTokenizer st = new StringTokenizer(str, " ", false);
            char root = st.nextToken().charAt(0);
            char lNode = st.nextToken().charAt(0);
            char rNode = st.nextToken().charAt(0);

            tree.createNode(root, lNode, rNode);
        }

        tree.preOrderTraversal(tree.root);
        System.out.println();

        tree.inOrderTraversal(tree.root);
        System.out.println();

        tree.postOrderTraversal(tree.root);
    }
}
