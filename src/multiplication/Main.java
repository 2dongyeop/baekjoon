package multiplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(final String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();

        solution(first, second);
    }

    private static void solution(String first, String second) {

        for (int i = second.length() - 1; i >= 0; i--) {
            System.out.println(
                    Integer.parseInt(first) *
                            Integer.parseInt(String.valueOf(second.charAt(i)))
            );
        }

        System.out.println(
                Integer.parseInt(first) *
                        Integer.parseInt(second)
        );
    }
}
