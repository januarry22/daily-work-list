package code.test.baekjoon;

import java.util.Arrays;

/*
 * 백준 - 행복
 * */
public class problem15969 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] wait = new int[N];
//        for(int i = 0; i < N; i++) {
//            wait[i] = sc.nextInt();
//        }
        int N = 8;
        int[] student = {27, 35, 92, 75, 42, 53, 29, 87};
        int result = 0;

        Arrays.sort(student);

        result = student[N-1]-student[0];

        System.out.println(result);
    }

}
