package baeknamTravel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        //격자판의 행의 수이자 열의 수인 N을 입력
        final int N = Integer.parseInt(br.readLine());
        final int[][] position = new int[N][N];

        initialize(position); //초기화

        //백남이의 좌표
        String[] str = br.readLine().split(" ");
        int r = Integer.parseInt(str[0]); //세로
        int c = Integer.parseInt(str[1]); //가로

        position[r][c] = 1; //시작 위치
        count++;

        while (!isVisited(position)) {
            int random = (int) Math.random() * 8; //0부터 7까지

            switch (random) {
                case 0:
                    if (r >= N - 2 || c == N - 1) break;

                    r += 2;
                    c += 1;
                    position[r][c] = 1;
                    count++;
                    break;
                case 1:
                    if (r == N - 1 || c >= N - 2) break;

                    r += 1;
                    c += 2;
                    position[r][c] = 1;
                    count++;
                    break;
                case 2:
                    if (r == 0 || c >= N - 2) break;

                    r -= 1;
                    c += 2;
                    position[r][c] = 1;
                    count++;
                    break;
                case 3:
                    if (r <= 1 || c == N - 1) break;

                    r -= 2;
                    c += 1;
                    position[r][c] = 1;
                    count++;
                    break;
                case 4:
                    if (r <= 1 || c == 0) break;

                    r -= 2;
                    c -= 1;
                    position[r][c] = 1;
                    count++;
                    break;
                case 5:
                    if (r == 0 || c <= 1) break;

                    r -= 1;
                    c -= 2;
                    position[r][c] = 1;
                    count++;
                    break;
                case 6:
                    if (r == N - 1 || c <= 1) break;

                    r += 1;
                    c -= 2;
                    position[r][c] = 1;
                    count++;
                    break;
                case 7:
                    if (r >= N - 2 || c == 0) break;

                    r += 1;
                    c -= 1;
                    position[r][c] = 1;
                    count++;
                    break;
            }
        }
        System.out.println(count);
    }

    private static void initialize(int[][] position) {
        for (int i = 0; i < position.length; i++)
            for (int j = 0; j < position[i].length; j++)
                position[i][j] = 0; //모두 0으로 초기화
    }


    private static boolean isVisited(int[][] position) {
        int visitCount = 0;
        for (int i = 0; i < position.length; i++)
            for (int j = 0; j < position[i].length; j++)
                if (position[i][j] == 1) {
                    visitCount++;
                }

        if (visitCount == position.length * position.length) return true;
        else return true;
    }
}
