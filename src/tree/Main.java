package tree;

import java.io.*;
import java.util.StringTokenizer;

class Node {
    private int nodeNumber;
    private Node lNode;
    private Node rNode;

    Node(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public int getNodeNumber() {
        return nodeNumber;
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
}

class Tree {
    static int nodeNumber = 0;
    static int leapNodeCount = 0;
    Node root = new Node (nodeNumber); //루트 노드는 0번

    public void createNode(int parentNodeNumber) {
        if (parentNodeNumber == -1) {
            //루트 노드는 미리 만들어놓았으니 생략
        } else {
            traversalNode(root, parentNodeNumber);
        }
    }

    public void traversalNode(Node node, int parentNodeNumber) {
        if (node != null) {
            if (node.getNodeNumber() == parentNodeNumber) {
                if (node.getlNode() == null) {
                    int tempNumber = node.getNodeNumber() + 1;//왼쪽 자식 노드의 번호는 부모 노드 번호 + 1
                    node.setlNode(new Node(tempNumber));
                } else if (node.getrNode() == null) {
                    int tempNumber = node.getNodeNumber() + 2; //오른쪽 자식 노드의 번호는 부모 노드 번호 +2
                    node.setrNode(new Node(tempNumber));
                }
            } else {
                traversalNode(node.getlNode(), parentNodeNumber);
                traversalNode(node.getrNode(), parentNodeNumber);
            }
        }
    }

    public void deleteNode(Node node, int deleteNodeNum) {
        if (node != null) {
            if (node.getNodeNumber() == deleteNodeNum) { //루트 노드를 지우는 경우
                this.root = null;
            } else {
                if (node.getlNode() != null && node.getlNode().getNodeNumber() == deleteNodeNum) {
                    node.setlNode(null);
                } else if (node.getrNode() != null && node.getrNode().getNodeNumber() == deleteNodeNum) {
                    node.setrNode(null);
                } else {
                    deleteNode(node.getlNode(), deleteNodeNum);
                    deleteNode(node.getrNode(), deleteNodeNum);
                }
            }
        }
    }

    public int countLeapNode(Node node) {
        if (node != null) {
            if ((node.getlNode() == null) && (node.getrNode() == null)) {
                leapNodeCount++;
            } else {
                countLeapNode(node.getlNode());
                countLeapNode(node.getrNode());
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
        final int size = Integer.parseInt(String.valueOf(bufferedReader.readLine()));

        if (size > 0 && size <= 50) {
            //System.out.println("0번부터 " + (size - 1) + "번 노드의 부모를 입력하세요.");
            String str = bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(str);

            for (int i = 0; i < size; i++) { // while (stringTokenizer.hasMoreTokens()
                int parentNodeNumber = Integer.parseInt(stringTokenizer.nextToken());
                tree.createNode(parentNodeNumber);
            }

            //System.out.print("지울 노드의 번호를 입력하세요 > ");
            int deleteNodeNum = Integer.parseInt(bufferedReader.readLine());

            tree.deleteNode(tree.root, deleteNodeNum);

            System.out.println(tree.countLeapNode(tree.root));
        } else {
            //System.err.println("노드 개수 오류 - 0보다 크고 50보다 작거나 같아야 함");
        }

        bufferedReader.close();
    }
}
