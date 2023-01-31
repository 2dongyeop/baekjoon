package dice3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(final String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int third = Integer.parseInt(st.nextToken());

        solution(first, second, third);
    }

    private static final void solution(int first, int second, int third) {

        int result = duplicateValidation(first, second, third);

        switch (result) {
            case 0: firstCase(first, second, third); break;
            case 2: secondCase(first, second, third); break;
            case 3: thirdCase(first); break;
        }

    }

    private static void firstCase(int first, int second, int third) {
        int max = 0;
        if (first > second) {
            max = Math.max(first, third);
        } else {
            max = Math.max(second, third);
        }

        System.out.println(max * 100);
    }

    private static void secondCase(int first, int second, int third) {
        int sameValue = 0;
        if (first == second) sameValue = first;
        else if (second == third) sameValue = second;
        else sameValue = third;

        System.out.println(1000 + sameValue * 100);
    }

    private static void thirdCase(int first) {
        System.out.println(10000 + first * 1000);
    }

    private static int duplicateValidation(int first, int second, int third) {
        if (first != second && second != third && third != first) return 0;
        else { //COMMENT 적어도 한 쌍의 중복이 존재
            if (first == second && second == third && third == first) return 3;
            else return 2;
        }
    }
}
