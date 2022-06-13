package binarySearchTree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        setlNode(null);
        setrNode(null);
    }
}

class Tree {
    Node root;

    public void createNode(int data) {
        if (root == null) {
            root = new Node(data);
            root.setlNode(null);
            root.setrNode(null);
        } else {
            traversalNode(root, data);
        }
    }

    public void traversalNode(Node node, int data) {
        if (node.getData() < data) {
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
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Tree tree = new Tree();

        System.out.println("전위 순회 방식으로 정렬한 노드들의 데이터를 입력합니다.");
        for (int i = 0; i < SIZE; i++) {
            int data = Integer.parseInt(bufferedReader.readLine());

            tree.createNode(data);
        }


        tree.postOrderTraversal(tree.root);

        bufferedReader.close();
    }
}
