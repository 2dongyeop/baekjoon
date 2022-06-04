package treeTraversal;

import java.util.Scanner;
import java.util.StringTokenizer;

class Node {
    private char data;
    private Node leftNode;
    private Node rightNode;

    char getData() {return this.data;}
    Node getLeftNode() {return this.leftNode;}
    Node getRightNode() {return this.rightNode;}
    void setData(char data) {this.data = data;}
    void setLeftNode(char leftNode) {new Node(leftNode);}
    void setRightNode(char rightNode) {new Node(rightNode);}

    Node(char data) {this.data = data;}

    Node(char data, char leftNode, char rightNode) {
        this.data = data;
        new Node(leftNode);
        new Node(rightNode);
    }
}

class Tree {
    public Node root;

    public void createNode(char data, char left, char right) {
        if (root == null) { //맨 처음 루트노드 생성 코드
            root = new Node(data);
            if (left != '.') root.setLeftNode(left);
            if (right != '.') root.setRightNode(right);
        } else {
            recursiveNode(root, data, left, right); //루트가 있다면 재귀 방식으로 해당 위치 이동
        }
    }

    public void recursiveNode(Node root, char data, char left, char right) {
        if (root.getData() == data) {
            if (left != '.') root.setLeftNode(left);
            if (right != '.') root.setRightNode(right);
        } else if (root == null) { //말단일 경우 여기로 들어와서 return됨
            return;
        } else { //해당 위치로 이동할 때까지 재귀 호출
            recursiveNode(root.getLeftNode(), data, left, right);
            recursiveNode(root.getRightNode(), data, left, right);
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
            System.out.print(node.getData());
            if (node.getLeftNode() != null) inOrderTraversal(node.getLeftNode());
            if (node.getRightNode() != null) inOrderTraversal(node.getRightNode());
        }
    }

    public void postOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.getData());
            if (node.getLeftNode() != null) postOrderTraversal(node.getLeftNode());
            if (node.getRightNode() != null) postOrderTraversal(node.getRightNode());
        }
    }
}

public class Tree_Traversal {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Tree tree = new Tree();

        System.out.print("생성할 노드 갯수를 입력하세요 > ");
        int nodeCount = scanner.nextInt();

        for(int i = 0; i < nodeCount; i++) {
            System.out.print((i + 1) + "번째 노드 이름, 왼쪽 자식 노드, 오른쪽 자식 노드를 순서대로 입력하세요 > ");
            scanner.nextLine(); //버퍼를 비워주는 역할
            String str = scanner.nextLine();//.next()는 공백을 못 읽음

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
