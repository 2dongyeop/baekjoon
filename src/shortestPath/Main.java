package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static List<Node> nodeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //System.out.println("정점의 개수와 간선의 개수를 입력");
        String s = bufferedReader.readLine();

        StringTokenizer st1 = new StringTokenizer(s);

        int nodeCount = Integer.parseInt(st1.nextToken());
        int linkCount = Integer.parseInt(st1.nextToken());

        createNode(nodeCount);

//        System.out.println("시작 노드를 입력");
        String n = bufferedReader.readLine();

        for (int i = 0; i < linkCount; i++) {
//            System.out.println("시작 노드, 끝 노드, 가중치를 입력");
            String input = bufferedReader.readLine();

            StringTokenizer st2 = new StringTokenizer(input);
            String start = st2.nextToken();
            String end = st2.nextToken();
            String weight = st2.nextToken();

            int startInt = Integer.parseInt(start);
            int endInt = Integer.parseInt(end);
            int weightInt = Integer.parseInt(weight);

            linkingNode(startInt, endInt, weightInt);
        }



    }

    private static void createNode(int N) {
        for (int i = 1; i <= N; i++) {//1번 노드부터 ~ N번 노드 까지 생성
            nodeList.add(new Node(i));
        }
    }

    private static void linkingNode(int start, int end, int weight) {



    }
}

class Node {
    final int number;
    List<Integer> linkedNode = new ArrayList<>();       //연결된 노드들
    List<Integer> linkedWeight = new ArrayList<>();     //간선들 가중치

    Node(int number) {
        this.number = number;
    }
}