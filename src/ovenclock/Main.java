package ovenclock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(final String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int cookingTime = Integer.parseInt(br.readLine());

        solution(hour, minute, cookingTime);
    }

    private static final void solution(int hour, int minute, int cookingTime) {

        int addHour = (minute + cookingTime) / 60;
        int newMinute = (minute + cookingTime) % 60;

        int newHour = hour + addHour;
        if (newHour >= 24) newHour = newHour % 24;

        System.out.println(newHour + " " + newMinute);
    }
}
