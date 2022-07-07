package code.test.programmers;

import java.util.Arrays;

/*
* [프로그래머스] - N개의 최소 공배
 * */
public class lessons12953 {

    public static void main(String[] args){
        int[] arr ={2,6,8,14};

        int answer = arr[0];

        for (int i=0; i<arr.length; i++){
            int ucd = eucd(answer, arr[i]);
            answer = answer*arr[i] / ucd;
        }
        System.out.println(answer);
    }

    public static int eucd(int a, int b) {
        /* a가 큰값으로 세팅 */
        int ucd = a % b;
        if(ucd ==0){
            return b;
        }else{
            return eucd(b, ucd);
        }
    }

}
