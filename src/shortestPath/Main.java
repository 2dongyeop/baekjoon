package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static List<Node> graph = new ArrayList<>();
    private static int nodeCount;
    private static int linkCount;

    public static void main(String[] args) throws IOException {
        //System.out.println("정점의 개수와 간선의 개수를 입력");
        String s = bufferedReader.readLine();

        StringTokenizer st1 = new StringTokenizer(s);

        nodeCount = Integer.parseInt(st1.nextToken());
        linkCount = Integer.parseInt(st1.nextToken());

        createNode(nodeCount);

//        System.out.println("시작 노드를 입력");
        String startNodeNum = bufferedReader.readLine();

        for (int i = 0; i < linkCount; i++) {
//            System.out.println("간선 정보 : 시작 노드, 끝 노드, 가중치를 입력");
            String input = bufferedReader.readLine();

            StringTokenizer st2 = new StringTokenizer(input);
            String start = st2.nextToken();
            String end = st2.nextToken();
            String weight = st2.nextToken();

            int startInt = Integer.parseInt(start);
            int endInt = Integer.parseInt(end);
            int weightInt = Integer.parseInt(weight);

            createLinking(startInt, endInt, weightInt);
        }

        //시작 정점을 이용한 거리 출력문 필요
        printDistance(Integer.parseInt(startNodeNum));
    }

    private static void createNode(int N) {
        for (int i = 1; i <= N; i++) {//1번 노드부터 ~ N번 노드 까지 생성
            graph.add(new Node(i));
        }
    }

    private static void createLinking(int start, int end, int weight) {
        for (int i = 0; i < graph.size(); i++)
            if (graph.get(i).number == start)
                graph.set(i, new Node(start, new Edge(end, weight)));
    }

    private static void printDistance(int startNodeNum) {
        Node startNode = null;
        for (Node n : graph) {
            if (n.number == startNodeNum) {
                startNode = n;  //시작 노드 지정
            }
        }

        //직접 연결되어 있을 경우
        for (int i = 0; i < nodeCount; i++) {
            if (i == startNodeNum) {
                System.out.println("0");
            } else if (startNode.edgeList.get(i).linkedNode == i) { //직접 연결이 된 경우
                System.out.println(startNode.edgeList.get(i).weight);
            } else {  //연결이 안된 경우
                System.out.println("INF");
            }
        }
    }
}

class Node {
    final int number;
    List<Edge> edgeList = new ArrayList<>();

    Node(int number) {
        this.number = number;
    }

    Node(int number, Edge edge) {
        this.number = number;
        edgeList.add(edge);
    }
}

class Edge {
    int linkedNode; //연결된 상대 노드 번호를 저장
    int weight;     //간선의 가중치

    Edge(int linkedNode, int weight) {
        this.weight = weight;
        this.linkedNode = linkedNode;
    }
}