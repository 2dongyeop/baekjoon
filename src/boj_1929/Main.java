package boj_1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        prime = new boolean[n + 1];
        getPrime();

        for (int i = m; i <= n; i++) {
            if (!prime[i]) System.out.println(i);
        }
    }

    private static void getPrime() {
        //true = 일반 숫자, false = 소수
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) continue;
            for (int j = i *i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
