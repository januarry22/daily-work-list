package code.test.baekjoon.silver;

import java.io.IOException;
import java.util.Scanner;

/*
 * 백준 - 팔
 *
 * */
public class problem1105 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int R = sc.nextInt();

        String a = Integer.toString(L);
        String b = Integer.toString(R);
        int min = 0;

        if (a.length() == b.length()) {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    break;
                } else {
                    if (b.charAt(i) == '8') {
                        min++;
                    }
                }
            }
        }

        System.out.println(min);

    }

}
