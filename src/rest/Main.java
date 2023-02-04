package rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //comment 초기설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] rest = new boolean[42];
        for (int i = 0; i < rest.length; i++) {
            rest[i] = false;
        }

        //comment 입력
        for (int i = 0; i < 10; i++) {
            rest[(Integer.parseInt(br.readLine()) % 42)] = true;
        }

        //comment 솔루션
        int count = 0;
        for (int i = 0; i < rest.length; i++) {
            if (rest[i]) count++;
        }

        System.out.println(count);
    }
}
