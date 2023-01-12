package card2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final Queue<Integer> queue = new LinkedList<>();
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(final String... args) throws IOException {
        init(Integer.parseInt(br.readLine()));

        while (queue.size() != 1) {
            queue.poll();

            int newTop = queue.poll();
            queue.add(newTop);
        }
        System.out.println(queue.poll());
    }

    private static void init(final int N) {
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
    }
}
