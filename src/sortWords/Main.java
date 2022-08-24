package sortWords;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String[] words;

    public static void main(String[] args) throws IOException {
        int wordCount = Integer.parseInt(br.readLine());

        words = new String[wordCount];
        inputWord(wordCount);

        Arrays.sort(words, new Comparator<String>() {

            @Override
            public int compare(String word1, String word2) {
                if (word1.length() == word2.length()) {
                    return word1.compareTo(word2);
                } else {
                    return word1.length() - word2.length();
                }
            }
        });

        printWord(words);
    }

    private static void inputWord(int wordCount) throws IOException {

        for (int i = 0; i < wordCount; i++) {
            String word = br.readLine();

            words[i] = word;
        }
    }

    private static void printWord(String[] str) {
        System.out.println(str[0]);

        for(int i = 1; i < str.length; i++) {
            if (!str[i].equals(str[i - 1])) {
                System.out.println(str[i]);
            }
        }
    }
}
