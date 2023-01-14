package ShowMeTheCode.multiverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static ArrayList<Integer>[] spaces;

    private static int spaceCount;
    private static int planetCount;

    private static StringTokenizer st;
    public static void main(final String... args) throws IOException {

        init();

        System.out.println(solution());
    }

    private static int solution() {
        int answer = 0;

        for (int i = 0; i < spaceCount - 1; i++) {
            for (int j = i + 1; j < spaceCount; j++) {
                if (!compare(spaces[i], spaces[j])) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private static boolean compare(ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2) {

        for (int i = 0; i < planetCount - 1; i++) {
            for (int j = i + 1; j < planetCount; j++) {
                if (arrayList1.get(i) > arrayList1.get(j) && arrayList2.get(i) <= arrayList2.get(j)) {
                    return true;
                }
                else if (arrayList1.get(i) < arrayList1.get(j) && arrayList2.get(i) >= arrayList2.get(j)) {
                    return true;
                }
                else {
                    if (arrayList2.get(i) != arrayList2.get(j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        spaceCount = Integer.parseInt(st.nextToken());
        planetCount = Integer.parseInt(st.nextToken());

        spaces = new ArrayList[spaceCount];

        for (int i = 0; i < spaceCount; i++) {
            spaces[i] = new ArrayList<>();
        }

        for (int i = 0; i < spaceCount; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < planetCount; j++) {
                spaces[i].add(Integer.valueOf(st.nextToken()));
            }
        }
    }
}
