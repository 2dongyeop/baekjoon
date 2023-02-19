package boj_9020.timeOverflow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCount; i++) {
            solution(Integer.parseInt(br.readLine()));
        }
    }

    private static void solution(int number) {
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        for (int i = 2; i <= (number + 1) / 2; i++) {

            int first = i;
            int second = number - first;

            if (isSosu(first) && isSosu(second)) {

                firstList.add(first);
                secondList.add(second);
            }

        }
        printBestAnswer(firstList, secondList);
    }

    private static void printBestAnswer(List<Integer> firstList, List<Integer> secondList) {
        int index = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < firstList.size(); i++) {
            if (min > secondList.get(i) - firstList.get(i)) {
                min = secondList.get(i) - firstList.get(i);
                index = i;
            }
        }

        System.out.println(firstList.get(index) + " " + secondList.get(index));
    }

    private static boolean isSosu(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
