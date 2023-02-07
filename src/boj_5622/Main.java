package boj_5622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            solution(str.charAt(i));
        }

        System.out.println(answer);
    }

    private static void solution(char charAt) {
        if (charAt == 'A' || charAt == 'B' || charAt == 'C') {
            answer += 3;
        } else if (charAt == 'D' || charAt == 'E' || charAt == 'F') {
            answer += 4;
        } else if (charAt == 'G' || charAt == 'H' || charAt == 'I') {
            answer += 5;
        } else if (charAt == 'J' || charAt == 'K' || charAt == 'L') {
            answer += 6;
        } else if (charAt == 'M' || charAt == 'N' || charAt == 'O') {
            answer += 7;
        } else if (charAt == 'P' || charAt == 'Q' || charAt == 'R' || charAt == 'S') {
            answer += 8;
        } else if (charAt == 'T' || charAt == 'U' || charAt == 'V') {
            answer += 9;
        } else if (charAt == 'X' || charAt == 'Y' || charAt == 'W' || charAt == 'Z') {
            answer += 10;
        }
    }
}
