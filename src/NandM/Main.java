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

        seriesNM(N, M);
    }

    private static final void seriesNM(final int N, final int M) throws IOException {
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 1; j <= M; j++) {
//                bufferedWriter.write(j +" ");
//                bufferedWriter.flush();
//            }
//            bufferedWriter.write("\n");
//            bufferedWriter.flush();
//        }

        bufferedWriter.close();
    }
}
