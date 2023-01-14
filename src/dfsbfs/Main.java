package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static boolean[] visited;
    private static List<Integer>[] graph;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //정점 개수
        int M = Integer.parseInt(st.nextToken()); //간선 개수
        int startNode = Integer.parseInt(st.nextToken());

        init(N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            makeLink(start, end);
        }

        for (int i = 1; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];
        dfs(startNode);

        System.out.println();

        visited = new boolean[N + 1];
        bfs(startNode);
    }

    private static void bfs(final int startNode) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");

            for (int i : graph[temp]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }

        }
    }

    private static void dfs(final int startNode) {
        visited[startNode] = true;
        System.out.print(startNode + " ");

        for (int i : graph[startNode]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    private static void makeLink(final int start, final int end) {
        graph[start].add(end);
        graph[end].add(start);
    }

    private static void init(final int N) {
        graph = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
    }
}
