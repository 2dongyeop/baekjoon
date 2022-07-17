package networkConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<Node>[] graph;
    private static int nodeCount;
    private static int edgeCount;

    public static void main(String[] args) throws IOException {
        nodeCount = Integer.parseInt(br.readLine());
        edgeCount = Integer.parseInt(br.readLine());

        initialize();

        for (int i = 0; i < edgeCount; i++) {
            String[] input = br.readLine().split(" ");
            createEdge(Integer.parseInt(input[0]), Integer.parseInt(input[1]),
                    Integer.parseInt(input[2]));
        }

        prim();
    }

    private static final void initialize() {
        graph = new ArrayList[nodeCount + 1];

        for (int i = 1; i < nodeCount + 1; i++)
            graph[i] = new ArrayList<>();
    }

    private static final void createEdge(final int start, final int end, final int weight) {
        graph[start].add(new Node(end, weight));
        graph[end].add(new Node(start, weight));
    }

    private static final void prim() {
        PriorityQueue<Node> pq = new PriorityQueue();

        boolean visited[] = new boolean[nodeCount + 1]; //방문한 노드를 표시

        pq.add(new Node(1, 0)); //시작 노드는 상관x

        int result = 0;
        int count = 0; //방문한 간선의 개수를 저장

        while (!pq.isEmpty()) {
            Node current = pq.poll(); //우선순위 큐로 구현하여 최소 간선이 꺼내짐

            if (visited[current.linkedNode]) {
                continue;          //연결된 노드가 방문된 상태이면 아래 과정 생략
            }

            visited[current.linkedNode] = true;
            result += current.weight;

            if (++count == nodeCount) { //모든 vertex를 다 찾은 상태
                System.out.println(result);
                break;
            }

            //해당 vertex와 연결된 모든 vertex를 큐에 넣음
            for (Node next : graph[current.linkedNode]) {
                    pq.add(next);
            }

        } //end-while


    }
}

class Node implements Comparable<Node> {
    int linkedNode;
    int weight;

    Node(final int linkedNode, final int weight) {
        this.linkedNode = linkedNode;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}