package code.test.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 백준 - ATM
 * */
public class problem11399 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] wait = new int[N];
//        for(int i = 0; i < N; i++) {
//            wait[i] = sc.nextInt();
//        }
        int N = 5;
        int[] wait = {3, 1, 4, 3, 2};
        int min = 0;

        Arrays.sort(wait);

        int sum = 0;
        for (int a : wait){
            min += sum + a;
            sum += a;
        }

        System.out.print(min);
    }

}
