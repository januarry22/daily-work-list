package code.test.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 - Mixing Milk
 *
 * */
public class problem16769 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int T = Integer.parseInt(br.readLine());
//
//        StringBuilder sb = new StringBuilder();
//        for (int t = 0; t < T; t++) {
//            int N = Integer.parseInt(br.readLine());
//            int C[] = new int[N];
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int i = 0; i < N; i++) {
//                C[i] = Integer.valueOf(st.nextToken());
//            }
//        }
        int[][] milk = {{10, 3},
                        {11, 4},
                        {12, 5}};

        int i = 0;
        for (int j = 0; j < milk.length; j++) {
            int prev = milk[j][1];
            int next = prev + milk[j][1];
            prev = prev - milk[j][1];
            System.out.println(prev);
            System.out.println(next);
            milk[j][1] = prev;
            System.out.println(Arrays.toString(milk[i]));
        }



    }


}
