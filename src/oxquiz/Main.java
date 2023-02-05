package oxquiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String testCase = br.readLine();
            solution(testCase);
        }
    }

    private static void solution(final String testCase) {
        int answer = 0;
        int currentPoint = 0;

        for (int i = 0; i < testCase.length(); i++) {
            if (testCase.charAt(i) == 'O') {
                currentPoint++;
                answer += currentPoint;
            } else {
                currentPoint = 0;
            }
        }

        System.out.println(answer);
    }
}
