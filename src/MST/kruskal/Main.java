package MST.kruskal;

import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PriorityQueue<Edge> pq = new PriorityQueue<>();
    private static int total = 0;
    private static int[] parent;
    private static int nodeCount;
    private static int edgeCount;

    public static void main(String[] args) throws IOException {
        String[] str = br.readLine().split(" ");
        nodeCount = Integer.parseInt(str[0]);
        edgeCount = Integer.parseInt(str[1]);

        initialize();

        for (int i = 0; i < edgeCount; i++) {
            String[] input = br.readLine().split(" ");
            int to = Integer.parseInt(input[0]);
            int from = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            pq.add(new Edge(to, from, weight));
        }

        kruskal();
    }

    private static void initialize() {
        parent = new int[nodeCount + 1];
        for (int i = 1; i < nodeCount + 1; i++) {
            parent[i] = i;
        }
    }

    private static void kruskal() {
        for (int i = 0; i < pq.size(); i++) {
            Edge edge = pq.poll();

            int to = find(edge.to);
            int from = find(edge.from);

            if (!isSameParent(to, from)) {
                total += edge.value;
                union(edge.to, edge.from);
            }
        }
        System.out.println(total);
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return true;
        else return false;
    }
}

class Edge implements Comparable<Edge> {
    int to;
    int from;
    int value;

    public Edge(int to, int from, int value) {
        this.to = to;
        this.from = from;
        this.value = value;
    }

    @Override
    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}
