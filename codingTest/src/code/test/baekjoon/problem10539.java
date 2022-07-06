package code.test.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 백준 - 수빈이와 수
 * */
public class problem10539 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] wait = new int[N];
//        for(int i = 0; i < N; i++) {
//            wait[i] = sc.nextInt();
//        }

        int[] A = {1, 3, 2, 6, 8};
        int[] B = {1, 2, 2, 3, 4};
        int[] C = new int[B.length];

//        int sum =0;
//        for(int i=0; i<A.length; i++){
//            sum += A[i];
//            C[i] = sum /(i+1);
//        }

        int sum =0;
        for(int j=0; j<B.length; j++){
            C[j] = B[j] * (j+1)-sum;
            sum += C[j];
        }


        for(int a: C){
            System.out.println(a);
        }
    }

}
