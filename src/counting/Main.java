package counting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; i++) array[i] = Integer.parseInt(st.nextToken());

        int target = Integer.parseInt(br.readLine());

        int count = 0;
        for (int a : array) {
            if (a == target) count++;
        }

        System.out.println(count);
    }
}
