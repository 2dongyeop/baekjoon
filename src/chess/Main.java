package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int king = Integer.parseInt(st.nextToken());
        int queen = Integer.parseInt(st.nextToken());
        int look = Integer.parseInt(st.nextToken());
        int bshop = Integer.parseInt(st.nextToken());
        int night = Integer.parseInt(st.nextToken());
        int phone = Integer.parseInt(st.nextToken());

        System.out.print(1 - king + " ");
        System.out.print(1 - queen + " ");
        System.out.print(2 - look + " ");
        System.out.print(2 - bshop + " ");
        System.out.print(2 - night + " ");
        System.out.println(8 - phone);
    }
}
