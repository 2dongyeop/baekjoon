package max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(final String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[9];

        for (int i = 0; i < 9; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        //comment 솔루션
        int max = 0;
        int result = 0;
        for (int i = 0; i < 9; i++) {
            if (array[i] > max) {
                max = array[i];
                result = i;
            }
        }

        System.out.println(max);
        System.out.println(result + 1);

    }
}
