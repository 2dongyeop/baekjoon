package constructionSiteSign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 - 대학교 대회 - 충남대학교
// 백준 - 23055번 : 공사장 표지판
public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("표지판의 크기(N * N)에 해당하는 정수를 입력하세요");
        int N = Integer.parseInt(bufferedReader.readLine());

        makeSiteSign(N);
    }

    private static void makeSiteSign(int N) {
        if (N == 1) {
            System.out.println("*");
        }

        for (int i = 0; i < N; i++) {     //세로 N줄
            System.out.print("*");  //가로 줄에서 처음 * 출력

            if (i == 0) {
                for (int j = 0; j < N - 2; j++)
                    System.out.print("*");
            } else if (i == N - 1) {
                for (int j = 0; j < N - 2; j++)
                    System.out.print("*");
            } else {
                for (int j = 0; j < N - 2; j++) {
                    /*
                    * i == 1 -> j = 0, 12
                    * i == 2 -> j = 1, 11
                    * i == 3 -> j = 2, 10
                    *
                    * */
                    if (j == i - 1 || j == N - (i + 1)) System.out.print("*");
                    else System.out.print(" ");

                }
            }
            System.out.println("*");  //가로 줄에서 마지막 * 출력
        }
    }
}