package sortWords;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final List<Word> wordList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int wordCount = Integer.parseInt(br.readLine());

        inputWord(wordCount);

        Collections.sort(wordList);

        printWord(wordList);
    }

    private static void inputWord(int wordCount) throws IOException {
        for (int i = 0; i < wordCount; i++) {
            String word = br.readLine();

            wordList.add(new Word(word));
        }
    }

    private static void printWord(List<Word> list) {
        System.out.println(list.get(0).getWord());

        for(int i = 1; i < list.size(); i++) {
            if (!list.get(i).getWord().equals(list.get(i - 1).getWord())) {
                System.out.println(list.get(i).getWord());
            }
        }
    }
}

class Word implements Comparable<Word> {
    private final String word;

    Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public int compareTo(Word o) {
        if (this.word.length() == o.word.length()) {
            return this.word.compareTo(o.word);
        } else {
            return this.word.length() - o.word.length();
        }
    }
}
