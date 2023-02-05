package boj_4673;


/**
 * 셀프 넘버
 */
public class Main {
    public static void main(String[] args) {
        boolean[] check = new boolean[10001];

        for (int i = 1; i < check.length; i++) {
            int n = d(i);

            if (n < 10001) {
                check[n] = true;
            }
        }

        for (int i = 1; i < check.length; i++) {
            if (check[i]) continue;
            System.out.println(i);
        }
    }

    /**
     * d() 메서드는 매개변수로 들어온 Number를 생성자로 하는 수를 리턴
     * ex) 11이 입력되면 11 + 1 + 1인 13을 리턴
     */
    private static int d(int number) {
        int sum = number;

        while (number != 0) {
            //comment 1의 자리 를 더함
            sum += (number % 10);
            //comment 1의 자리를 제거 (123을 12로)
            number = number / 10;
        }

        return sum;
    }
}
