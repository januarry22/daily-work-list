package code.test.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 - The candy war
 *
 * */
public class problem9037 {

    public static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int C[] = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                C[i] = Integer.valueOf(st.nextToken());
            }
            C = circle(C, N, N);
            System.out.println(cnt);
        }
//        int N = 4;
//        int[] C = {3, 4, 4, 3};
//        C = circle(C, N, N);
//        System.out.println(cnt);
//        System.out.println(Arrays.toString(C));
    }


    public static int[] candy(int[] C) {
        for (int i = 0; i < C.length; i++) {
            if (C[i] % 2 != 0) {
                C[i]++;
            }
        }
        return C;
    }

    public static int[] circle(int[] C, int N, int len) {
        int[] arr = new int[N];
        if(N==1){
            cnt = 0;
            return new int[]{0};
        }
        C = candy(C);
        //        System.out.println(Arrays.toString(C));

        for (int i = 0; i < N; i++) {
            int mine = 0;
            int right = 0;
            if (i == 0) {
                mine = C[i] / 2;
                right = C[N - 1] / 2;
            } else {
                mine = C[i] / 2;
                right = C[i - 1] / 2;
            }
            arr[i] = mine + right;
        }
        //       System.out.println(Arrays.toString(arr));

        // 배열 중복 제거
        int[] carr = Arrays.stream(arr).distinct().toArray();
        len = carr.length;
        if (len == 1) {
            return carr;
        }
        cnt ++;
        return circle(arr, N, len);
    }
}
