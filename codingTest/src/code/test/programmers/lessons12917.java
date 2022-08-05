package code.test.programmers;

import java.util.Arrays;

/*
* [프로그래머스] - 문자열 내림차순으로 배치하기
 * */
public class lessons12917 {


    public static void main(String[] args){
        String s = "Zbcdefg";
        String answer = "";
        char[] a = s.toCharArray();

        Arrays.sort(a);

        for(int i=s.length()-1; i>=0;i--){
           answer += a[i];
        }


        System.out.println(answer);

    }



}
