package receipt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(final String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int totalPrice = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        int currentPrice = 0;

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            currentPrice += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        }

        if (totalPrice == currentPrice) System.out.println("Yes");
        else System.out.println("No");
    }
}
