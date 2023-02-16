package boj_1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] array = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int a : array) {
            if (a == 1) {
                count++;
                continue;
            }

            for (int i = 2; i < a; i++) {
                if (a % i == 0) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(n - count);
    }
}
