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

    public Node(int data) {
        this.data = data;
        setlNode(null);
        setrNode(null);
    }
}

class Tree {
    Node root;

    void createNode(int data) {
        if (root == null) {
            root = new Node(data);
            root.setlNode(null);
            root.setrNode(null);
        } else {
            traversalNode(root, data);
        }
    }

    void traversalNode(Node node, int data) {
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

    void postOrderTraversal(Node node) {
        if (node != null) {
            if (node.getlNode() != null) postOrderTraversal(node.getlNode());
            if (node.getrNode() != null) postOrderTraversal(node.getrNode());
            System.out.println(node.getData());
        }
    }
}

public class Main {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Tree tree = new Tree();

        //System.out.println("전위 순회 방식으로 정렬한 노드들의 데이터를 입력합니다.");
        while (true) {

            String data = bufferedReader.readLine();
            if (!isNumber(data)) {
                break;
            }
            int intData = Integer.parseInt(data);
            tree.createNode(intData);
        }
        tree.postOrderTraversal(tree.root);

        bufferedReader.close();
    }

    public static boolean isNumber(String str) {
        try {
            int data = Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
