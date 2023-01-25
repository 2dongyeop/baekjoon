package findTreeParent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int[] parents;
    private static boolean[] visited;

    private static List<Integer>[] nodeList;
    public static void main(String[] args) throws IOException {

        /**
         * 초기화
         */
        int nodeCount = Integer.parseInt(br.readLine());
        nodeList = new ArrayList[nodeCount + 1]; //0 ~ 8
        parents = new int[nodeCount + 1];
        visited = new boolean[nodeCount + 1];

        for (int i = 1; i <= nodeCount; i++) {
            nodeList[i] = new ArrayList<>();
        }

        /**
         * 예제 입력 처리
         */
        for (int i = 1; i < nodeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());

            nodeList[firstNode].add(secondNode);
            nodeList[secondNode].add(firstNode);
        }

        /**
         * solution
         */
        for (int i = 1; i <= nodeCount; i++) {
            if (!visited[i]) {
                solution(i);
            }
        }

        for (int i = 2; i <= nodeCount; i++) {
            System.out.println(parents[i]);
        }

        br.close();
    }

    private static void solution(int startNode) {
        //TODO DFS
        if (visited[startNode]) {
            return;
        }

        visited[startNode] = true;
        for (int node : nodeList[startNode]) {
            if (!visited[node]) {
                parents[node] = startNode;
                solution(node);
            }
        }

    }
}
