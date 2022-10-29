package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final static StringBuilder stringBuilder = new StringBuilder();

    public static void main(final String[] args) throws IOException {
//        System.out.print("문자열의 길이 > ");
        int length = Integer.parseInt(br.readLine());

//        System.out.print("입력 문자열 > ");
        String inputString = br.readLine();

        hashing(length, inputString);
    }

    private static void hashing(int length, String str) {
        // H = sigma (i = 0부터 length-1까지) a(i)*r^i mod M
        // r = 31, M = 1234567891로 지정.
        long r = 1;
        long result = 0;
        char[] chars = new char[length];
        long[] results = new long[length];
        for (int i = 0 ; i < length; i++) {
            chars[i] = str.charAt(i);
        }

        for (int i = 0; i < chars.length; i++) {
            results[i] = transformASCII(chars[i]);
        }

        for (long l : results) {
            result += (l * r) % 1234567891;
            r = (r * 31) % 1234567891;
        }

        System.out.println(result % 1234567891);
    }

    private static int transformASCII(char c) {
        return (int) (c - 'a' + 1);
    }
}
