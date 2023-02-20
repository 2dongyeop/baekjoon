package boj_2563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] wall = new int[100][100];
        int paperCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < paperCount; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int a = x; a < x + 10; a++) {
                for (int b = y; b < y + 10; b++) {
                    wall[a][b] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (wall[i][j] == 1) count++;
            }
        }

        System.out.println(count);
    }
}
