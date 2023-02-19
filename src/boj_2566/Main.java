package boj_2566;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] array = new int[9][9];

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 9; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int resultI = 0;
        int resultJ = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                    resultI = i;
                    resultJ = j;
                }
            }
        }

        System.out.println(max);
        System.out.println((resultI + 1) + " " + (resultJ + 1));
    }
}
