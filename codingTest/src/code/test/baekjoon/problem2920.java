package code.test.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 백준 - 음계
 *
 * */
public class problem2920 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];

        for (int i = 0; i < 8; i++) {
            arr[i] = sc.nextInt();
        }

        int[] ascending = {1, 2 ,3 ,4 ,5, 6 ,7, 8};
        int[] descending = {8, 7, 6, 5, 4, 3, 2, 1};
        String[] result = { "ascending", "descending", "mixed"};

        String answer = "";

        if(Arrays.equals(ascending, arr)){
            answer = result[0];
        }
        else if(Arrays.equals(descending, arr)){
            answer = result[1];
        }else{
            answer = result[2];
        }

        System.out.println(answer);

    }

}
