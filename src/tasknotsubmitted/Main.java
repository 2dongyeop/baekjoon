package tasknotsubmitted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(final String... args) throws IOException {
        //comment 초기 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] submitted = new boolean[30];
        for (int i = 0; i < submitted.length; i++) {
            submitted[i] = false;
        }

        //comment 입력
        for (int i = 0; i < 28; i++) {
            submitted[Integer.parseInt(br.readLine()) - 1] = true;
        }

        //comment 솔루션
        for (int i = 0; i < submitted.length; i++) {
            if (submitted[i]) continue;
            System.out.println(i + 1);
        }
    }
}
