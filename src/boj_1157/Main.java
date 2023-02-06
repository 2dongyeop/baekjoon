package boj_1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //comment init
        int[] alpha = new int[26];
        for (int i = 0; i < alpha.length; i++) {
            alpha[i] = 0;
        }

        //comment input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String s = input.toUpperCase();

        //comment input-handling
        for (int i = 0; i < s.length(); i++) {
            int al = s.charAt(i) - 65;
            alpha[al]++;
        }

        //comment choose-max
        int max = 0;
        int index = 0;
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] > max) {
                max = alpha[i];
                index = i;
            }
        }

        //comment count Max
        int maxCount = 0;
        for (int i : alpha) {
            if (i == max) {
                maxCount ++;
            }
        }

        //comment answer
        if (maxCount == 1) {
            char a = 'a';
            char answer = (char) (a + index - 32);
            System.out.println(answer);
        } else {
            System.out.println("?");
        }
    }
}
