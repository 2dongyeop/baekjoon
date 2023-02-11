package boj_2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        //comment: solution
        int current = 0;
        int count = 0;
//        int speed = a - b;
        while (current < V) {
            current += a;

            if (current < V) { //commment 아직 도착 안했다면
                current -= b;
            }

            count++;
        }

        System.out.println(count);
    }
}
