package goldbach.conjecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static boolean[] primeNumbers;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(final String... args) throws IOException {
        int number;

        primeNumberEratosthenesSieve();

        while (!((number = Integer.parseInt(br.readLine())) == 0)) {
            solution(number);
        }
    }

    private static void solution(final int number) {
        int first, second;

        for (first = 3; first <= number / 2; first++) {
            second = number - first;

            if (primeNumbers[first] && primeNumbers[second]) {
                printAnswer(number, first, second);
                return;
            }
        }
        System.out.println("Goldbach's conjecture is wrong.");
    }

    private static void primeNumberEratosthenesSieve() {
        primeNumbers = new boolean[1000001];

        for (int i = 2; i <= 1000000; i++) {
            primeNumbers[i] = true;
        }

        for (int i = 2; i <= 1000000; i++) {
            if (!primeNumbers[i]) continue;

            for (int j = i * 2; j <= 1000000; j += i) {
                primeNumbers[j] = false;
            }
        }
    }

    private static void printAnswer(final int number, final int first, final int second) {
        System.out.println(number + " = " + first + " + " + second);
    }
}
