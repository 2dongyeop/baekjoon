package aplusbminus5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(final String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean isDuplicatedZero = false;

        while (!isDuplicatedZero) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0) {
                isDuplicatedZero = true;
                break;
            }

            System.out.println(a + b);
        }

    }
}
