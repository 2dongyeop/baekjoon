package boj_2587;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[5];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        for (int a : array) {
            sum += a;
        }

        Arrays.sort(array);

        int avg = sum / 5;
        System.out.println(avg);

        System.out.println(array[2]);

    }
}
