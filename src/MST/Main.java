package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<Node>[] graph;
    private static int vCount;
    private static int eCount;

    public static void main(String[] args) throws IOException {
        //정점의 개수 V와 간선의 개수 E를 입력
        String[] str = br.readLine().split(" ");

        vCount = Integer.parseInt(str[0]);
        eCount = Integer.parseInt(str[1]);

        //초기화 작업
        initialize();

        //간선 추가 작업
        for (int i = 0; i < eCount; i++) {
            str = br.readLine().split(" ");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);
            int weight = Integer.parseInt(str[2]);

            linkingEdge(start, end, weight);
        }

        //prim algorithm
        prim();
    }

    private static void initialize() {
        graph = new ArrayList[vCount + 1];
        for (int i = 1; i < vCount + 1; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    private static void linkingEdge(int start,
                                    int end, int weight) {
        graph[start].add(new Node(end, weight));
        graph[end].add(new Node(start, weight));
    }

    private static void prim() {
        boolean visited[] = new boolean[vCount + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        long result = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (visited[current.linkedNodeNum]) {
                continue;
            }

            visited[current.linkedNodeNum] = true;
            result += current.weight;

            if (++count == vCount) {
                System.out.println(result);
                break;
            }

            for (Node next : graph[current.linkedNodeNum]) {
                pq.add(next);
            }

        } //end-while
    }
}

class Node implements Comparable<Node> {
    final int linkedNodeNum; //연결된 노드 번호
    final int weight;        //해당 간선 가중치

    Node(final int linkedNodeNum, final int weight) {
        this.linkedNodeNum = linkedNodeNum;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}
