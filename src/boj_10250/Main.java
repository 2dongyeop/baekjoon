package boj_10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < testCount; i++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            boolean[][] hotel = new boolean[W][H];
            int count = 0;
            int resultH = 0;
            int resultW = 0;

            //comment: solution
            SOL: for (int w = 0; w < W; w++) {
                for (int h = 0; h < H; h++) {
                    if (hotel[w][h] != true) {
                        hotel[w][h] = true;
                        count++;
                        if (count == N) {
                            resultW = w;
                            resultH = h;
                            break SOL;
                        }
                    }
                }
            }

            System.out.println(100 * (resultH + 1) + (resultW + 1));
        }

    }
}
