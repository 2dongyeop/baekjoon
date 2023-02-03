package maxmin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Main {
    public static void main(final String... args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) array[i] = parseInt(st.nextToken());

        int max = MIN_VALUE, min = MAX_VALUE;
        for (int a : array) {
            if (a > max) max = a;
            if (a < min) min = a;
        }

        System.out.println(min + " " + max);
    }
}
