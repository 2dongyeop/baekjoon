package boj_7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(br.readLine());
        List<Person> personList = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < testCount; i++) {
            st = new StringTokenizer(br.readLine());
            personList.add(new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        solution(personList);
    }

    private static void solution(List<Person> personList) {

        StringBuilder sb = new StringBuilder();

        for (Person p1: personList) {
            int count = 1;

            for (Person p2: personList) {
                if (p1.weight < p2.weight && p1.height < p2.height) {
                    count++;
                }
            }

            sb.append(count).append(" ");
        }
        System.out.println(sb);
    }

    static class Person {
        int weight;
        int height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}
