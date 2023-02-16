package boj_2581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        solution(m, n);
    }

    private static void solution(final int m, final int n) {
        int min = Integer.MAX_VALUE;
        int sum = 0;

        //comment: m부터 n까지 순회
        Outer:
        for (int i = m; i <= n; i++) {
            //comment: 기본 값은 소수임

            if (i == 1) {
                continue;
            }

            //comment: 2부터 m - 1까지 나누기
            for (int j = 2; j < i; j++) {
                //comment: 하나라도 나누어 떨어지는게 있으면 소수가 아님
                if (i % j == 0) {
                    continue Outer;
                }
            }
            sum += i;
            if (min > i) {
                min = i;
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
