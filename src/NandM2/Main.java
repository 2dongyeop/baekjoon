package NandM2;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        //첫째 줄에 자연수 N과 M이 주어짐
        String s = bufferedReader.readLine();
        StringTokenizer st = new StringTokenizer(s);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        backTracking(1, 0);
        System.out.println(sb);
    }

    private static void backTracking(final int at, final int depth) {
        if (depth == M) {
            for (int val : arr) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            backTracking(i + 1, depth + 1);
        }
    }
}
