package serialnumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(final String... args) throws IOException {
        List<String> list = new LinkedList<>();

        final int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //길이가 다르면 짧은게 우선
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }
                //길이가 같다면 문자열 내 숫자의 합이 작은게 우선
                if (calculate(o1) != calculate(o2)) {
                    return calculate(o1) - calculate(o2);
                }
                //그것도 아니면 사전순 정렬
                return o1.compareTo(o2);
            }
        });

        for (String s : list) {
            System.out.println(s);
        }
    }

    private static int calculate(final String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sum += s.charAt(i);
            }
        }
        return sum;
    }
}
