package testresult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.parseInt(br.readLine());

        if (result >= 90) System.out.println("A");
        else if (result >= 80) System.out.println("B");
        else if (result >= 70) System.out.println("C");
        else if (result >= 60) System.out.println("D");
        else System.out.println("F");
    }
}
