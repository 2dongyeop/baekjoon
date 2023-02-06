package boj_2675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCount; i++) {
            st = new StringTokenizer(br.readLine());

            solution(Integer.parseInt(st.nextToken()), st.nextToken());
        }
    }

    private static void solution(int count, String s) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < count; j++) {
                answer += s.charAt(i);
            }
        }

        System.out.println(answer);
    }
}
