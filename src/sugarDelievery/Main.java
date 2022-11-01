package sugarDelievery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<Answer> answerList = new ArrayList<>();
    private static final int BIG = 5;
    private static final int SMALL = 3;
    private static int kg, quotient;

    public static void main(String[] args) throws IOException {
        kg = Integer.parseInt(br.readLine());

        quotient = kg / BIG;

        dynamic();
    }

    private static void dynamic() {
        int quoitentSmall;
        boolean isDivided = false;

        if (kg % SMALL == 0) {
            quoitentSmall = (kg / SMALL);
            answerList.add(new Answer(0, quoitentSmall));
            isDivided = true;
        }

        for (int i = 0; i <= quotient; i++) {
            if ((kg - (BIG * i)) % SMALL == 0) {
                quoitentSmall = (kg - (BIG * i)) / SMALL;
                answerList.add(new Answer(i, quoitentSmall));
                isDivided = true;
            }
        }

        if (isDivided) {
            chooseAnswer();
        } else {
            System.out.println("-1");
        }
    }

    private static void chooseAnswer() {
        int result = 1667;

        for (Answer a : answerList) {
            if (result >= a.remainder + a.quotient)
                result = a.remainder + a.quotient;
        }

        System.out.println(result);
    }

    static class Answer {
        int quotient;
        int remainder;

        Answer(int quotient, int remainder) {
            this.quotient = quotient;
            this.remainder = remainder;
        }
    }
}
