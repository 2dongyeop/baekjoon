package participantsList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static PriorityQueue<Participants> list = new PriorityQueue<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        System.out.println("학급 수 N과 학급당 신청 가능한 인원수 M을 입력");
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean isEOF = false;

        do {
//        for (int i = 0; i < M; i++) {
//            System.out.println("학급과 이름을 입력하세요");
            String input = br.readLine();

            st = new StringTokenizer(input);

            String classNumber = st.nextToken();
            String name = st.nextToken();

            if (classNumber == "0" && name == "0") isEOF = true;

            int classNumberInt = Integer.parseInt(classNumber);

            list.add(new Participants(classNumberInt, name));
        } while (!isEOF);

        printList(list);
    }

    private static void printList(PriorityQueue<Participants> list) {
        for (Participants p : list) {
            System.out.println(p.classNumber + " " + p.name);
        }
    }
}

class Participants {
    int classNumber;
    String name;

    Participants(int classNumber, String name) {
        this.classNumber = classNumber;
        this.name = name;
    }
}