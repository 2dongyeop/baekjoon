package boj_2908;

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

        solution(a, b);
    }

    private static void solution(int a, int b) {
        String reverseA = "";
        String reverseB = "";

        while (a != 0) {
            reverseA += a % 10;
            a /= 10;
        }

        while (b != 0) {
            reverseB += b % 10;
            b /= 10;
        }

        int newA = Integer.parseInt(reverseA);
        int newB = Integer.parseInt(reverseB);

        int answer = newA >= newB ? newA : newB;

        System.out.println(answer);
    }
}
