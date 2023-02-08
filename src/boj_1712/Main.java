package boj_1712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        //comment: solution
        solution(a, b, c);
    }

    private static void solution(int a, int b, int c) {

        int result = 0;
        if (b >= c) {
            System.out.println(-1);
            return;
        }

        result = a / (c - b);

        System.out.println(result + 1);

    }
}
