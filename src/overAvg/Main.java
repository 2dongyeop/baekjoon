package overAvg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseCount; i++) {
            st = new StringTokenizer(br.readLine());
            int studentCount = Integer.parseInt(st.nextToken());
            int[] scores = new int[studentCount];

            for (int j = 0; j < studentCount; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
            }

            //comment 솔루션
            solution(scores);
        }
    }

    private static void solution(int[] scores) {
        double avg = (double) Arrays.stream(scores).sum() / scores.length;
        double count = 0;

        for (int score: scores) {
            if (score > avg) count++;
        }

        System.out.printf("%.3f", count / scores.length * 100);
        System.out.println("%");
    }
}
