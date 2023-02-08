package boj_1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int count = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            if (check()) {
                count++;
            }
        }
        System.out.print(count);
    }

    public static boolean check() throws IOException {
        //comment : 알파벳별로 나왔는지 저장
        boolean[] check = new boolean[26];
        int prev = 0;
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i);

            //comment: 현재 알파벳과 이전 알파벳이 다르다면
            if (prev != now) {
                //comment: 현재 알파벳이 처음 나온 경우
                if (!check[now - 'a']) {
                    //comment: 나왔다고 기록해놓고
                    check[now - 'a'] = true;
                    //comment : prev에 현재 알파벳을 저장
                    prev = now;
                }
                //comment: 현재 알파벳이 처음이 아닌 경우
                else {
                    return false;
                }
            }
        }
        return true;
    }
}