package tree;

import java.util.Scanner;
import java.util.StringTokenizer;

class Node {
    private int nodeNumber;
    private Node parentNode;
    private Node lNode;
    private Node rNode;

    Node(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public int getNodeNumber() { return nodeNumber; }
    public Node getlNode() { return lNode; }
    public Node getrNode() {return rNode; }
    public void setlNode(Node node) { this.lNode = node; }
    public void setrNode(Node node) { this.rNode = node; }
    public void setNodeNumber(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }
}

class Tree {
    static int nodeNumber = 0;
    Node root;

    public void createNode(int parentNodeNumber) {
        if (parentNodeNumber == -1) {
            root.setNodeNumber(nodeNumber);
            nodeNumber++;
        } else {
            traversalNode(root, parentNodeNumber);
        }
    }

    public void traversalNode(Node node, int parentNodeNumber) {
        if (node.getNodeNumber() == parentNodeNumber) {
            if (node.getlNode() == null) {
                node.setlNode(new Node(parentNodeNumber));
                nodeNumber++;
            } else if (node.getrNode() == null) {
                node.setrNode(new Node(parentNodeNumber));
                nodeNumber++;
            }
        } else {
            traversalNode(node.getlNode(), parentNodeNumber);
            traversalNode(node.getrNode(), parentNodeNumber);
        }
    }

    public int countLeapNode(Node node) {
        int count = 0;

        if (node.getlNode() == null) { count++; }
        else if (node.getrNode() == null) { count++; }
        else {
            countLeapNode(node.getlNode());
            countLeapNode(node.getrNode());
        }

        return count;
    }
}


public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Tree tree = new Tree();

        System.out.print("노드 개수를 입력하세요 > ");
        final int size = scanner.nextInt();

        System.out.println("0번부터 " + (size - 1) + "번 노드의 부모를 입력하세요.");
        scanner.nextLine(); //버퍼를 비워주는 역할?
        String str = scanner.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(str);

        while (stringTokenizer.hasMoreTokens()) {
            int parentNodeNumber = Integer.parseInt(stringTokenizer.nextToken());
            tree.createNode(parentNodeNumber);
        }

        System.out.println(tree.countLeapNode(tree.root));
    }
}
