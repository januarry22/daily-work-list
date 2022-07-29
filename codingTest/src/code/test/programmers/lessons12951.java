package code.test.programmers;

import java.util.Arrays;

/*
 * [프로그래머스] -JadenCase 문자열 만들기
 * */
public class lessons12951 {

    public static void main(String[] args) {
        String str = "3people unFollowed me";
        String[] b = str.toLowerCase().split(" ");
        String answer = "";

        for (String first : b) {
            char ch = first.charAt(0);
            System.out.println("char ::" + ch);
            if (!Character.isUpperCase(ch)) {
                answer+=first.replace(first.charAt(0), Character.toUpperCase(ch))+" ";
            }
        }

        System.out.println("answer ::" + answer.stripTrailing());
    }

}
