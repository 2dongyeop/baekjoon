package boj_1085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        solution(x, y, w, h);
        br.close();
    }

    private static void solution(int x, int y, int w, int h) {
        int result = x;

        if (result > y) {
            result = y;
        }

        if (result > w - x) {
            result = w - x;
        }

        if (result > h - y) {
            result = h - y;
        }

        System.out.println(result);
    }
}
