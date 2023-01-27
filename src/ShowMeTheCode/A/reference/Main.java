package ShowMeTheCode.A.reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static int[] stones;
    private static StringTokenizer st;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String... args) throws IOException {

        int N = Integer.parseInt(br.readLine()); // 돌상의 개수
        stones = new int[N];

        /* 초기화작업  */
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }

        /* 솔루션 */
        System.out.println(solution());
    }

    private static int solution() {
        int leftMax = 0, rightMax = 0, totalMax = 0;

        for (int i = 0; i < stones.length; i++) {

            if (stones[i] == LEFT) {
                leftMax++;
                rightMax--;
            } else if (stones[i] == RIGHT) {
                leftMax--;
                rightMax++;
            }

            if (leftMax > totalMax || rightMax > totalMax) {
                totalMax = Math.max(leftMax, rightMax);
            }

            if (leftMax < 0) leftMax = 0;
            if (rightMax < 0) rightMax = 0;
        }

        return totalMax;
    }
}
