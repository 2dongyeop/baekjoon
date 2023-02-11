package boj_1193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //합이 1인거 1개
        //합이 2인거 2개
        //합이 3인거 3개
        //합이 4인거 4개
        //합이 5인거 5개

        int findNumber = Integer.parseInt(br.readLine());
        int sum = 0;
        int level = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
            if (sum >= findNumber) {
                level = i;
                break;
            }
        }
//        System.out.println("level = " + level);


        int indexByLevel;
        if (findNumber == 1) {
            System.out.println("1/1");
            return;
        } else if (findNumber == 2) {
            System.out.println("1/2");
            return;
        } else if (findNumber == 3) {
            System.out.println("2/1");
            return;
        } else {
            indexByLevel = findNumber - (level) * (level - 1) / 2; //답이 1
        }
//        System.out.println("indexByLevel = " + indexByLevel);

        //분자
        int numerator;
        //분모
        int denominator;

        if (level % 2 == 1) { //comment 짝수이면
            //분자
            numerator = level;
            //분모
            denominator = 1;

            for (int i = 1; i < indexByLevel; i++) {
                numerator--;
                denominator++;
            }
        } else {
            //분자
            numerator = 1;
            //분모
            denominator = level;

            for (int i = 1; i < indexByLevel; i++) {
                numerator++;
                denominator--;
            }
        }

        System.out.println(numerator + "/" + denominator);
    }
}
