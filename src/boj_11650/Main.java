package boj_11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.x != o2.x) {
                    return o1.x - o2.x;
                } else {
                    return o1.y - o2.y;
                }
            }
        });

        for (Node node : nodes) {
            System.out.println(node.x + " " + node.y);
        }
    }

    static class Node {
        final int x;
        final int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
