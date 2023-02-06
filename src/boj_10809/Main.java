package boj_10809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        //comment solution
        for (char alpha = 'a'; alpha <= 'z'; alpha++) {
            System.out.print(input.indexOf(alpha) + " ");
        }

    }
}
