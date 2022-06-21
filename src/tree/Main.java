package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    private int nodeNumber;
    private Node lNode = null;
    private Node rNode = null;

    Node(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public Node getlNode() {
        return lNode;
    }

    public Node getrNode() {
        return rNode;
    }

    public int getNodeNumber() {
        return nodeNumber;
    }

    public void setlNode(Node node) {
        this.lNode = node;
    }

    public void setrNode(Node node) {
        this.rNode = node;
    }

    public void setNodeNumber(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }
}

class Tree {
    static int nodeNumber = 0;
    static int leapNodeCount = 0;
    static Node root = new Node(nodeNumber); //루트 노드는 0번

    public void createNode(int parentNodeNumber) {
        if (parentNodeNumber == -1) {
            //root = new Node(nodeNumber);
            System.out.println("루트(0번) 노드 생성");
        } else {
            traversalNode(root, parentNodeNumber);
        }
    }

    public void traversalNode(Node node, int parentNodeNumber) {
        if (node != null) {
            if (node.getNodeNumber() == parentNodeNumber) { //부모 번호가 노드의 번호와 일치하면
                if (node.getlNode() == null) { //왼쪽 자식으로 생성
                    node.setlNode(new Node(++nodeNumber));
                    System.out.println(nodeNumber + "번 노드 생성");
                } else if (node.getrNode() == null) { //오른쪽 자식으로 생성
                    node.setrNode(new Node(++nodeNumber));
                    System.out.println(nodeNumber + "번 노드 생성");
                }
            } else {
                if (node.getlNode() != null) traversalNode(node.getlNode(), parentNodeNumber);
                if (node.getrNode() != null) traversalNode(node.getrNode(), parentNodeNumber);
            }
        }
    }

    public void selectDeleteNode(Node node, int deleteNodeNum) {
        if (node != null) {
            if (node.getNodeNumber() == deleteNodeNum) {
                deleteChildNode(node); //해당 노드와 자식들을 지움
            } else {
                if (node.getlNode() != null) selectDeleteNode(node.getlNode(), deleteNodeNum);
                if (node.getrNode() != null) selectDeleteNode(node.getrNode(), deleteNodeNum);
            }
        }
    }

    public void deleteChildNode(Node node) {
        if (node != null) {
            //먼저 자식 노드들을 지우는 과정
            if (node.getlNode() != null) deleteChildNode(node.getlNode());
            if (node.getrNode() != null) deleteChildNode(node.getrNode());

            //현재 위치 노드를 지움
            //노드 번호는 -1~50이므로 지워진 노드의 번호는 -2로 지정
            System.out.println(node.getNodeNumber() + "번 노드 삭제");
            node.setlNode(null);
            node.setrNode(null);
            node.setNodeNumber(-2);
        }
    }

    public int countLeapNode(Node node) {
        if (node != null && node.getNodeNumber() >= 0) {
            if ((node.getlNode() == null) && (node.getrNode() == null)) {
                System.out.println(node.getNodeNumber() + "번이 리프 노드");
                leapNodeCount++;
            } else {
                if (node.getlNode() != null) countLeapNode(node.getlNode());
                if (node.getrNode() != null) countLeapNode(node.getrNode());
            }
        }
        return leapNodeCount;
    }
}

public class Main {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final Tree tree = new Tree();

        //System.out.print("노드 개수를 입력하세요 > ");
        final int size = Integer.parseInt(bufferedReader.readLine());

        //System.out.println("0번부터 " + (size - 1) + "번 노드의 부모를 입력하세요.");
        String str = bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(str);

        for (int i = 0; i < size; i++) { // while (stringTokenizer.hasMoreTokens()
            int parentNodeNumber = Integer.parseInt(stringTokenizer.nextToken());
            tree.createNode(parentNodeNumber);
        }

        //System.out.print("지울 노드의 번호를 입력하세요 > ");
        int deleteNodeNum = Integer.parseInt(bufferedReader.readLine());

        tree.selectDeleteNode(tree.root, deleteNodeNum);
        System.out.println(tree.countLeapNode(tree.root));

        bufferedReader.close();
    }
}
