package plusCycle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cycle = 0;

        int input = Integer.parseInt(br.readLine());
        int newNumber = input;

        do {
            //COMMENT step 1 : 각 자리 숫자를 더하기
            String stringNewNumber = String.valueOf(newNumber);
            int sum = 0;
            for (int i = 0; i < stringNewNumber.length(); i++) {
                sum += Integer.parseInt(String.valueOf(stringNewNumber.charAt(i)));
            }

            //COMMENT step 2 : newNumber의 1의 자리 + 각 자리 수의 합의 1의 자리
            char a = stringNewNumber.charAt(stringNewNumber.length() - 1);
            String stringsum = String.valueOf(sum);
            char b = stringsum.charAt(stringsum.length() - 1);

            newNumber = (Integer.parseInt(String.valueOf(a))) * 10 + (Integer.parseInt(String.valueOf(b)));

            //COMMENT step 3 : 사이클 증가
            cycle++;
        } while (input != newNumber);

        System.out.println(cycle);
    }
}
