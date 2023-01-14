package ShowMeTheCode.medicine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(final String... args) throws IOException {
        int medicine = Integer.parseInt(br.readLine());

        System.out.println(solution(medicine));
    }

    private static int solution(final int n) {
        int result = 1;

        for (int i = 1; i < n; i++) {
            result *= 3;
        }

        return 2 * result;
    }
}
