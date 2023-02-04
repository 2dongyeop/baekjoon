package average;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //comment: init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double[] scores;

        //comment: input
        int n = Integer.parseInt(br.readLine());
        scores = new double[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        //comment: solution
        //comment: step-1 findMax
        double max = 0.0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) max = scores[i];
        }

        //comment: step-2 findNewScore
        for (int i = 0; i < n; i++) {
            double newScore = (scores[i] / max) * 100;
            scores[i] = newScore;
        }

        //comment: step-3 findAvg
        double sum = 0.0;
        for (double s : scores) {
            sum += s;
        }

        System.out.println(sum / scores.length);
    }
}
