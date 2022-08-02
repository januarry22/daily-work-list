package code.test.baekjoon.silver;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 백준 - 물병
 *
 * */
public class problem1052 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int answer = 0;

        while (true) {
            int bottle = N;
            int cnt = 0;
            while (bottle != 0) {
                if (bottle % 2 == 1) {
                    cnt++;
                }
                bottle = bottle / 2;
            }
            if (cnt <= K) {
                break;
            }
            answer++;
            N++;
        }

        System.out.println(answer);
    }
}
