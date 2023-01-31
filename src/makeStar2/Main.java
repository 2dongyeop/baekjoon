package makeStar2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(final String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1 - i; j++)
                System.out.print(" ");
            for (int k = N - 1 - i; k < N; k++)
                System.out.print("*");
            System.out.println("");
        }
    }
}
