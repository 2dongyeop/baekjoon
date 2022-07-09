package shortestPath.secondAttempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] list;
    private static int vCount; //정점 개수
    private static int eCount; //간선 개수
    private static int start;
    private static int[] distance;
    private static int INF = Integer.MAX_VALUE;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        //System.out.println("정점의 개수와 간선의 개수를 입력");
        String s = br.readLine();

        StringTokenizer st1 = new StringTokenizer(s);

        vCount = Integer.parseInt(st1.nextToken());
        eCount = Integer.parseInt(st1.nextToken());

//        System.out.println("시작 노드를 입력");
        String startNodeNum = br.readLine();

        list = new ArrayList[vCount + 1]; //정점 인접 리스트
        distance = new int[vCount + 1]; //시작점과 다른 정점간의 최단경로

        for (int i = 1; i <= vCount; i++)
            list[i] = new ArrayList<>();

        //초기화
        Arrays.fill(distance, INF);

        distance[start] = 0;
        for (int i = 0; i < eCount; i++) {
            String str = br.readLine();
            StringTokenizer st2 = new StringTokenizer(str);

            int u = Integer.parseInt(st2.nextToken()); //출발
            int v = Integer.parseInt(st2.nextToken()); //도착
            int w = Integer.parseInt(st2.nextToken()); //가중치

            list[u].add(new Node(v, w));
        }

        dijkstra();

        for (int i = 1; i <= vCount; i++) {
            if (distance[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }


    }

    private static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int vertex = node.vertex;
            int weight = node.weight;

            if (distance[vertex] < weight) { //지금께 더 가중치가 크면 갱신할 필요가 없다.
                continue;
            }
            for (int i = 0; i < list[vertex].size(); i++) {//해당 정점과 연결된 것들 탐색
                int vertex2 = list[vertex].get(i).vertex;
                int weight2 = list[vertex].get(i).weight + weight;
                if (distance[vertex2] > weight2) { //지금께 더 최단경로라면 갱신해준다.
                    distance[vertex2] = weight2;
                    queue.add(new Node(vertex2, weight2));
                }
            }
        }
    }
}

class Node implements Comparable<Node> { //시간 단축으로 성능 개선
    int vertex;
    int weight;

    Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}