package aplusb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();
        System.out.println(Integer.parseInt(a) + Integer.parseInt(b));
    }
}
