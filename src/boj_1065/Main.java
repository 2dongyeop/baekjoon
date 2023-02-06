package boj_1065;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        solution(n);
    }

    private static void solution(int number) {
        int count = 0;

        if (number < 100) {
            //comment 숫자가 100보다 작으면 무조건 등차수열이다.
            //comment 숫자가 한자리 -> 당연히 등차수열
            //comment 숫자가 두자리 -> 차가 1개뿐이므로 당연히 등차.
            System.out.println(number);
            return;
        } else {
            count = 99;

            for (int i = 100; i <= number; i++) {
                int hun = i / 100;       //comment 백의 자리 수
                int ten = (i / 10) % 10; //comment 십의 자리 수
                int one = i % 10;        //comment 일의 자리 수

                //comment 각 자릿수가 등차수열을 이루면 카운트 증가
                if ((hun - ten) == (ten - one)) count++;
            }
        }

        System.out.println(count);
    }
}
