package code.test.programmers;

import java.util.Arrays;

/*
 * [프로그래머스] - 자연수 뒤집어 배열로 만들기
 * */
public class lessons12932 {

    public static void main(String[] args) {
        long n = 12345;
        System.out.println(n);
        String s = Long.toString(n);

        int[] answer = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            answer[ s.length() -1-i] = Character.getNumericValue(s.charAt(i));
        }


        System.out.println(Arrays.toString(answer));
    }

}
