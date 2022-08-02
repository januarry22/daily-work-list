package code.test.baekjoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 백준
 *
 * */
public class problem1037 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();

        int[] M = new int[A];

        for (int i = 0; i < A; i++) {
            M[i] = sc.nextInt();
        }

        Arrays.sort(M);

        int answer = M[A-1] * M[0];

        System.out.println(answer);
    }

}
