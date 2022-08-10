package code.test.programmers;

import java.util.Arrays;

/*
 * [프로그래머스]
 * */
public class lessons12940 {
    public static void main(String[] args) {
            int[] answer = new int[2];
        int n  = 2;
        int m = 5;

        answer[0]=gcd(n,m);
        answer[1]=lcm(n,m);

        System.out.println(Arrays.toString(answer));
    }

    // 최대 공약수
    public static int gcd(int n, int m) {

        while (m != 0) {
            int a = n % m;
            n = m;
            m = a;
        }
        return n;
    }

    // 최소 공배수
    public static int lcm(int a, int b) {
        // 0이 아닌 두 수의 곱 / 두 수의 최대공약수
        return a * b / gcd(a, b);
    }
}
