package code.test.baekjoon.silver;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 백준 - Z
 *
 * */
public class problem1074 {
    public static int count =0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        int pow = (int)Math.pow(2, N);

        // 2N × 2N 인 2차원 배열
        int[][] place = new int[pow][pow];

        find(pow, r, c);

        System.out.println(count);
    }

    private static void find(int size, int r, int c) {
        if(size == 1)
            return;

        if(r < size/2 && c < size/2) {
            find(size/2, r, c);
        }
        else if(r < size/2 && c >= size/2) {
            count += size * size / 4;
            find(size/2, r, c - size/2);
        }
        else if(r >= size/2 && c < size/2) {
            count += (size * size / 4) * 2;
            find(size/2, r - size/2, c);
        }
        else {
            count += (size * size / 4) * 3;
            find(size/2, r - size/2, c - size/2);
        }
    }
}
