package thailandAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1998년생인 내가 태국에서는 2541년생?!
 * #18108
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int input = Integer.parseInt(br.readLine());
        System.out.println(input - 543);
    }
}
