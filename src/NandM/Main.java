package NandM;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        //첫째 줄에 자연수 N과 M이 주어짐
        String s = bufferedReader.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] temp = new int[N + 1]; //1~N까지 쓸 예정이지만 배열은 0부터 시작이므로 크기가 N+1
        boolean[] visit = new boolean[N + 1]; //방문 정보를 저장하는 배열

        visit[0] = true;                     //배열 초기화
        for (int i = 0; i <= N; i++) {
            temp[i] = i;
        }

        seriesNM(N, M, temp, visit);
    }

    private static final void seriesNM(final int N, final int M, final int temp[], final boolean visit[]) throws IOException {
        


//        while (true) {
//            for (int i = 1; i <= N; i++) {
//                bufferedWriter.write(i + "\n");
//
//                if (i == N) break; //for문 끝
//            }
//            bufferedWriter.flush();
//
//        }
    }
}
