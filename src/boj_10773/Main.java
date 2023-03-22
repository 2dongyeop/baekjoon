package boj_10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {

            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                stack.pop();
                continue;
            }

            stack.add(input);
        }

        int count = 0;

        for (int a : stack) {
            count += a;
        }

        System.out.println(count);
    }
}
