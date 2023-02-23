package boj_18870.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(br.readLine());
        int[] list = new int[testCount];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < testCount; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> visitnumber = new ArrayList<>();

        for (int i = 0; i < testCount; i++) {
            int count = 0;

            for (int a : list) {
                if (list[i] > a) {
                    count++;
                }
            }

            System.out.print(count + " ");
        }
    }


    public static boolean isVisited(List<Integer> list, int number) {
        for (int a : list) {
            if (a == number) {
                return true;
            }
        }
        return false;
    }
}
