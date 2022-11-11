package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_Java17 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Stack<Integer> stack = new Stack<>();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            classifyCommands(input);
        }
    }

    private static void classifyCommands(String input) {

        stringTokenizer = new StringTokenizer(input);

        if (stringTokenizer.countTokens() == 2) {
            stringTokenizer.nextToken();
            stack.push(Integer.parseInt(stringTokenizer.nextToken()));
        } else {
            classifyElse(input);
        }
    }

    private static void classifyElse(String input) {

        switch (input) {
            case "pop" -> {
                if (stack.empty()) System.out.println("-1");
                else
                    System.out.println(stack.pop());
            }
            case "size" -> System.out.println(stack.size());
            case "top" -> {
                if (stack.empty()) System.out.println("-1");
                else
                    System.out.println(stack.peek());
            }
            case "empty" -> System.out.println(validateEmpty(stack.empty()));
        }
    }

    private static int validateEmpty(boolean b) {

        if (b) {
            return 1;
        } else {
            return 0;
        }
    }
}