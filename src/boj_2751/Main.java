package boj_2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.add(Integer.valueOf(br.readLine()));
        }

        for (int i = 0; i < n; i++) {
            sb.append(queue.poll()).append('\n');
        }

        System.out.println(sb);
    }
}
