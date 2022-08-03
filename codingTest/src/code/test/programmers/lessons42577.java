package code.test.programmers;

import java.util.Arrays;

/*
 * [프로그래머스] - 전화번호 목록
 * */
public class lessons42577 {

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        boolean check = true;
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                check = false;
                break;
            }
        }
        System.out.println(check);
    }
}
