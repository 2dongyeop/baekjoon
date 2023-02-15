package boj_2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] apart = new int[15][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        init();

        int testCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCount; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(apart[k][n]);
        }

    }

    private static void init() {

        for (int i = 0; i < 15; i++) {
            apart[i][1] = 1; //i층 1호
            apart[0][i] = i; //0층 i호
        }

        for (int i = 1; i < 15; i++) { //1층부터 14층
            for (int j = 2; j < 15; j++) {
                apart[i][j] = apart[i][j - 1] + apart[i - 1][j];
            }
        }
    }
}
