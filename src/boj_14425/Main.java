package boj_14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int nCount = Integer.parseInt(st.nextToken());
        int mCount = Integer.parseInt(st.nextToken());

        String[] set = new String[nCount];
        for (int i = 0; i < nCount; i++) {
            set[i] = br.readLine();
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < mCount; i++) {
            list.add(br.readLine());
        }

        int count = 0;
        for (String setTemp: set) {
            for (String listTemp: list) {
                if (listTemp.equals(setTemp)) count++;
            }
        }

        System.out.println(count);
    }
}
