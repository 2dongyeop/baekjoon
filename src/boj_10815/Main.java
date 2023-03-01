package boj_10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //comment: N 입력받고 배열 정렬
        int n = Integer.parseInt(br.readLine());
        int[] arrayN = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrayN[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrayN);

        //comment: M 입력받
        int m = Integer.parseInt(br.readLine());
        int[] arrayM = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrayM[i] = Integer.parseInt(st.nextToken());
        }

        int[] results = new int[m];
        for (int i = 0; i < m; i++) {
            results[i] = 0;
        }

        //comment: solution
        for (int i = 0; i < m; i++) {
            if (solution(arrayN, arrayM[i])) {
                results[i] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int result : results) {
            sb.append(result).append(" ");
        }

        System.out.println(sb);
    }

    private static boolean solution(final int[] arrayN, final int searchValue) {
        int leftIndex = 0;
        int rightIndex = arrayN.length - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            int midValue = arrayN[midIndex];

            if (searchValue < midValue) {
                rightIndex = midIndex - 1;
            } else if (searchValue > midValue) {
                leftIndex = midIndex + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
